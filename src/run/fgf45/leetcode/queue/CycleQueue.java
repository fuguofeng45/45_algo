package run.fgf45.leetcode.queue;

/**
 * 循环队列
 */
public class CycleQueue {

    private static final int DEFAULT_SIZE = 10;

    private int size;
    private String [] data;
    private int head;
    private int tail;

    public CycleQueue(){
        this.size = DEFAULT_SIZE;
        data = new String[this.size];
    }

    public CycleQueue(int size){
        this.size = size;
        data = new String[this.size];
    }

    public String deQueue(){
        if(head == tail){
            return null;
        }
        String tmp = data[head];
        head = (head + 1) % size;
        return tmp;
    }

    public boolean enQueue(String v){
        if((tail + 1) % size == head){
            return false;
        }
        data[tail] = v;
        tail = (tail + 1) % size;
        return true;
    }

    public static void main(String[] args) {
        CycleQueue cycleQueue = new CycleQueue();
        for (int i = 0; i < 11; i++) {
            cycleQueue.enQueue(String.valueOf(i));
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(cycleQueue.deQueue());
        }
        for (int i = 0; i < 3; i++) {
            cycleQueue.enQueue(String.valueOf(i+"-"));
        }
    }

}
