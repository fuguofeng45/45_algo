package run.fgf45.leetcode.skiplist;

public class  SkipList {

    private static final float SKIPLIST_P = 0.5f;
    private static final int MAX_LEVEL = 16;

    private int levelCount = 1;

    /**
     * 跳表头结点。
     * 类似链表里的带头链表，哨兵结点，本身不存储数据，下一跳指向各层索引的头结点。
     */
    private Node head = new Node();  // 带头链表

    public Node find(int value) {
        Node p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.nextNodes[i] != null && p.nextNodes[i].data < value) {
                p = p.nextNodes[i];
            }
        }

        if (p.nextNodes[0] != null && p.nextNodes[0].data == value) {
            return p.nextNodes[0];
        } else {
            return null;
        }
    }

    public void insert(int value) {
        int level = randomLevel();
        Node newNode = new Node();
        newNode.data = value;
        newNode.maxLevel = level;
        //待插新节点在每一层的pre 结点数组
        Node preNodes[] = new Node[level];
        for (int i = 0; i < level; ++i) {
            preNodes[i] = head;
        }

        // record every level largest value which smaller than insert value in update[]
        Node p = head;
        for (int i = level - 1; i >= 0; --i) {
            while (p.nextNodes[i] != null && p.nextNodes[i].data < value) {
                p = p.nextNodes[i];
            }
            preNodes[i] = p;// use update save node in search path
        }

        // in search path node next node become new node forwords(next)
        for (int i = 0; i < level; ++i) {
            newNode.nextNodes[i] = preNodes[i].nextNodes[i];
            preNodes[i].nextNodes[i] = newNode;
        }

        // update node hight
        if (levelCount < level) {
            levelCount = level;
        }
    }

    public void delete(int value) {
        Node[] update = new Node[levelCount];
        Node p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.nextNodes[i] != null && p.nextNodes[i].data < value) {
                p = p.nextNodes[i];
            }
            //找到每层要删除节点的前序节点
            update[i] = p;
        }

        if (p.nextNodes[0] != null && p.nextNodes[0].data == value) {
            for (int i = levelCount - 1; i >= 0; --i) {
                if (update[i].nextNodes[i] != null && update[i].nextNodes[i].data == value) {
                    update[i].nextNodes[i] = update[i].nextNodes[i].nextNodes[i];
                }
            }
        }

        while (levelCount>1&&head.nextNodes[levelCount]==null){
            levelCount--;
        }

    }

    // 理论来讲，一级索引中元素个数应该占原始数据的 50%，二级索引中元素个数占 25%，三级索引12.5% ，一直到最顶层。
    // 因为这里每一层的晋升概率是 50%。对于每一个新插入的节点，都需要调用 randomLevel 生成一个合理的层数。
    // 该 randomLevel 方法会随机生成 1~MAX_LEVEL 之间的数，且 ：
    //        50%的概率返回 1
    //        25%的概率返回 2
    //      12.5%的概率返回 3 ...
    private int randomLevel() {
        int level = 1;

        while (Math.random() < SKIPLIST_P && level < MAX_LEVEL){
            level += 1;
        }
        return level;
    }

    public void printAll() {
        Node p = head;
        while (p.nextNodes[0] != null) {
            System.out.print(p.nextNodes[0] + " ");
            p = p.nextNodes[0];
        }
        System.out.println();
    }

    public class Node {
        private int data = -1;
        //当前节点在每一层的next节点数组
        private Node nextNodes[] = new Node[MAX_LEVEL];
        private int maxLevel = 0;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");

            return builder.toString();
        }
    }

    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        skipList.insert(1);
        skipList.insert(2);
        skipList.insert(3);
        skipList.insert(4);
        skipList.insert(5);
        skipList.insert(6);
        skipList.printAll();
    }

}
