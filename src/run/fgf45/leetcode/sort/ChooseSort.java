package run.fgf45.leetcode.sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class ChooseSort {

    public static int [] chooseSort(int [] data){
        int tempIndex = -1;
        for (int i = 0; i < data.length - 1; i++) {
            int mix = data[i];
            for (int j = i; j < data.length; j++) {
                if(j + 1 < data.length && data[j] < mix){
                    //找到最小数
                    mix = data[j];
                    tempIndex = j;
                }
            }
            if(tempIndex != -1){
                int tmp = mix;
                data[tempIndex] = data[i];
                data[i] = tmp;
            }
        }
        return data;
    }

    public static void main(String[] args) {
        int [] data = {1,2,3,4,5,67};
        Arrays.stream(chooseSort(data)).asLongStream().forEach(d -> {
            System.out.println(d);
        });
    }

}
