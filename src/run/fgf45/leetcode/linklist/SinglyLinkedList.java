package run.fgf45.leetcode.linklist;

/**
 * 判断字符串是否为回文
 */
public class SinglyLinkedList {

    public Node getHead() {
        return head;
    }

    private Node head = new Node(0, null);

    private int size;

    private Node fastNode;

    private Node slowNode;

    public SinglyLinkedList(int [] data){
        Node next = null;
        if(data == null){
            throw new IllegalArgumentException();
        }
        this.size = data.length;
        for (int i = data.length - 1; i >= 0; i--) {
            Node tmpNode = createNode(data[i], next);
            next = tmpNode;
            if(i != 0){
                head.next = next;
            }else {
                head.data = tmpNode.data;
            }
        }
    }

    public void sysOut() {
        Node next = null;
        next = this.head;
        while(next != null){
            System.out.println(next.data);
            next = next.next;
        }
    }

    public Node findMiddleNode(){
        Node tmp = null;
        this.slowNode = this.head;
        this.fastNode = this.head;
        while(fastNode.next != null && fastNode.next.next != null){
            this.slowNode = this.slowNode.next;
            this.fastNode = fastNode.next.next;
        }
        return slowNode;
    }

    public void reverseNode(){
        if(fastNode.next != null){
            //偶数
            this.slowNode = this.slowNode.next;
        }else{
            this.fastNode = this.fastNode.next;
        }
        Node indexNode = this.head.next;
        Node tmpHead = this.head;
        tmpHead.next = null;
        while(indexNode != this.slowNode){
            Node t = indexNode;
            indexNode = indexNode.next;
            t.next = tmpHead;
            tmpHead = t;
        }
        this.head.next = this.slowNode;
        this.head = tmpHead;
    }

    public boolean judgeIsReverse(){
        Node h = this.head;
        if(this.size % 2 != 0){
            //奇数
            this.slowNode = this.slowNode.next;
        }
        while(this.slowNode!=null){
            if(this.slowNode.data == h.data){
                h = h.next;
                this.slowNode = this.slowNode.next;
            }else{
                return false;
            }
        }
        return true;
    }

    public static Node createNode(int value, Node next){
        return new Node(value, next);
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        int [] data = {1, 2, 3, 3, 2, 2};
        SinglyLinkedList list = new SinglyLinkedList(data);
        list.findMiddleNode();
        list.reverseNode();
        System.out.println(list.judgeIsReverse());

    }

}
