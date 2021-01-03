package run.fgf45.leetcode.sort;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static int[] bubbleSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - i; j++) {
                if (j + 1 < data.length - i && data[j] > data[j + 1]) {
                    int tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                }
            }
        }
        return data;
    }

    public static void main(String[] args) {
        int [] data = {4,2,6,7};
        bubbleSort(data);
        Arrays.stream(data).asLongStream().forEach(value -> System.out.println(value));
    }

}
