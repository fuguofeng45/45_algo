package run.fgf45.leetcode.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {

    public static int [] insertSort(int [] data){
        for (int i = 0; i < data.length; i++) {
            int j = i - 1;
            int value = data[i];
            for (; j >= 0; j--) {
                if(value < data[j]){
                    data[j+1] = data[j];
                }
            }
            data[j+1] = value;
        }
        return data;
    }

    public static void main(String[] args) {
        int [] data = {4,2,6,7};
        insertSort(data);
        Arrays.stream(data).asLongStream().forEach(value -> System.out.println(value));
    }

}
