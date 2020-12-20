package run.fgf45.leetcode.linklist;

/**
 * reverList 反转链表
 */
public class ReverseLinkList {

    private Node head;

    public ReverseLinkList(int [] data){
        Node tmp = null;
        Node node = null;
        for (int i = data.length - 1; i >= 0; i--) {
            node = new Node(data[i], tmp);
            tmp = node;
        }
        head = node;
    }

    public void reverList(){
        if(head == null){
            return;
        }
        Node tmp = head.next;
        Node tmpHead = head;
        head.next = null;
        while(tmp != null){
            Node n = tmp;
            tmp = tmp.next;
            n.next = tmpHead;
            tmpHead = n;
        }
        head = tmpHead;

    }


    public static class Node{

        private Node next;
        private int data;

        public Node(){}

        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    " data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        int [] data = {1, 2, 3, 4, 5};
        ReverseLinkList linkList = new ReverseLinkList(data);
        //linkList.reverList();
        //System.out.println(linkList.head);
    }

}
