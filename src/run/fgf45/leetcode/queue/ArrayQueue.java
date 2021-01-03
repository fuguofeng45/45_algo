package run.fgf45.leetcode.queue;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 数组实现队列
 * @author fuguofeng
 */
public class ArrayQueue {

    private static final Integer DEFAULT_SIZE = 15;

    private String [] data;
    private AtomicInteger head = new AtomicInteger(0);
    private AtomicInteger tail = new AtomicInteger(0);
    private AtomicInteger size;

    public ArrayQueue(){
        this.size = new AtomicInteger(DEFAULT_SIZE);
        data = new String[this.size.get()];
    }

    protected String enQueue(){
        if(tail.getAndIncrement() == size.get() - 1){
            Arrays.copyOf(data, size.getAndAdd(DEFAULT_SIZE));
            return data[tail.get()];
        }
        return data[tail.getAndIncrement()];
    }

    protected String enQueue(String v){
        data[head.getAndIncrement()] = v;
        return v;
    }

}
