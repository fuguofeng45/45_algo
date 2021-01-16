package run.fgf45.leetcode.sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class ChooseSort {

    public static int[] chooseSort1(int[] data) {
        int tempIndex = -1;
        for (int i = 0; i < data.length - 1; i++) {
            int mix = data[i];
            for (int j = i; j < data.length; j++) {
                if (j + 1 < data.length && data[j] < mix) {
                    //找到最小数
                    mix = data[j];
                    tempIndex = j;
                }
            }
            if (tempIndex != -1) {
                int tmp = mix;
                data[tempIndex] = data[i];
                data[i] = tmp;
            }
        }
        return data;
    }

    public static int[] chooseSort2(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int min = i;
            for (int j = i; j < data.length; j++) {
                if (data[j] < data[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int tmp = data[i];
                data[i] = data[min];
                data[min] = tmp;
            }
        }
        return data;
    }

    public static int[] chooseSort3(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int mix = i;
            for (int j = i; j < data.length; j++) {
                if(data[j] < data[mix]){
                    mix = j;
                }
            }
            //swap
            if(mix != i){
                int temp = data[mix];
                data[mix] = data[i];
                data[i] = temp;
            }
        }
        return data;
    }

    public static int[] chooseSort4(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int mix = i;
            for (int j = i; j < data.length; j++) {
                if(data[j] < data[mix]){
                    j = mix;
                }
            }
            //swap
            if(mix != i){
                int temp = data[mix];
                data[mix] = data[i];
                data[i] = temp;
            }
        }
        return data;
    }

    public static void main(String[] args) {
        int[] data = {5, 2, 3, 4, 1, 67};
        Arrays.stream(chooseSort3(data)).asLongStream().forEach(d -> {
            System.out.println(d);
        });
    }

}
