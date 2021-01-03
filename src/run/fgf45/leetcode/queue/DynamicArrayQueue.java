package run.fgf45.leetcode.queue;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 动态扩容数组
 */
public class DynamicArrayQueue {

    private static final Integer DEFAULT_SIZE = 10;
    private static final Integer DEFAULT_START_INDEX = 0;

    private int head;
    private int tail;
    private String [] data;

    public DynamicArrayQueue(){
        data = new String[DEFAULT_SIZE];
    }

    public String deQueue(){
        if(head == tail){
            head = DEFAULT_START_INDEX;
            tail = DEFAULT_START_INDEX;
            return null;
        }
        return data[head++];
    }

    public boolean enQueue(String value){
        boolean isCanEnQueue = (head == 0 && tail == data.length - 1) || tail == data.length - 1;
        if(isCanEnQueue){
            //扩容
            data = Arrays.copyOf(data, DEFAULT_SIZE * 2);
        }
        data[tail] = value;
        tail++;
        return true;
    }


    public static void main(String[] args) {
        /*DynamicArrayQueue dynamicArrayQueue = new DynamicArrayQueue();
        for (int i = 0; i < 11; i++) {
            dynamicArrayQueue.enQueue(String.valueOf(i));
        }
        for (int i = 0; i < 12; i++) {
            System.out.println(dynamicArrayQueue.deQueue());
        }
        for (int i = 0; i < 4; i++) {
            dynamicArrayQueue.enQueue(i + "$");
        }*/
        Map m = new ConcurrentHashMap<>();
        m.put("1", "1");
        m.put("2", "2");
        m.put("3", "3");
        m.put("4", "4");
        m.clear();
        m.put("5", "6");
        System.out.println(m.size());
    }

}
