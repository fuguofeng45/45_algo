package run.fgf45.leetcode.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {

    /**
     * 错误的排序方法
     * @param data
     * @return
     */
    @Deprecated
    public static int[] insertSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int j = i - 1;
            int value = data[i];
            for (; j >= 0; j--) {
                if (value < data[j]) {
                    data[j + 1] = data[j];
                }
            }
            data[j + 1] = value;
        }
        return data;
    }

    /**
     * 插入排序
     * @param data
     * @return
     */
    public static int[] insertSort2(int[] data) {
        for (int i = 0; i < data.length; i++) {
            boolean isSort = false;
            int exchangeVal = data[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                //goback
                if (data[j] > exchangeVal) {
                    isSort = true;
                    data[j + 1] = data[j];
                } else {
                    break;
                }
            }
            if(isSort){
                data[j + 1] = exchangeVal;
            }
        }
        return data;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        Arrays.stream(insertSort2(data)).asLongStream().forEach(value -> System.out.println(value));
    }

}
