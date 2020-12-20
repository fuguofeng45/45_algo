package run.fgf45.leetcode.stack;

/**
 * 链表模拟stack
 * @author fuguofeng
 */
public class LinkListStack {

    private int size;
    private Node head = new Node(Integer.MAX_VALUE, null);

    public static Node createNode(int value, Node next){
        return new Node(value, next);
    }

    public LinkListStack(){
    }

    protected void clear(){
        head.next = null;
    }

    protected Object pop(){
        if(head.next == null){
            throw new RuntimeException("data is not exist!");
        }
        Node tmp = head.next;
        head.next = tmp.next;
        return tmp;
    }

    protected void push(Integer v){
        if(v == null){
            throw new RuntimeException("value is null!");
        }
        Node newData = new Node(v, null);
        Node tmp = head.next;
        head.next = newData;
        newData.next = tmp;
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
        LinkListStack stack = new LinkListStack();
        System.out.println(stack.head);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        stack.push(5);
    }

}
