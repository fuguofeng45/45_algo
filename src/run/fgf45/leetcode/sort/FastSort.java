package run.fgf45.leetcode.sort;

import java.util.Arrays;

public class FastSort {

    /**
     * 主入口
     *
     * @param data
     */
    public static void fastSort(int[] data) {
        fastSort(data, 0, data.length - 1);
    }

    /**
     * 分制递归
     *
     * @param data
     * @param left
     * @param right
     */
    public static void fastSort(int[] data, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = sortByPivot(data, left, right);
        fastSort(data, left, pivot - 1);
        fastSort(data, pivot + 1, right);

    }

    /**
     * 获取pivot
     *
     * @param data
     * @param left
     * @param right
     * @return
     */
    public static int sortByPivot(int[] data, int left, int right) {
        int pivotValue = data[right];
        int j = left;
        for (int i = left; i < right; i++) {
            if (data[i] < pivotValue) {
                int tmp = data[j];
                data[j] = data[i];
                data[i] = tmp;
                j++;
            }
        }
        int t = data[j];
        data[j] = data[right];
        data[right] = t;
        return j;
    }

    public static void main(String[] args) {
        int[] data = {10, 5, 7, 1, 2, 3, 9, 7};
        fastSort(data);
        Arrays.stream(data).asLongStream().forEach(d -> {
            System.out.println(d);
        });
    }


}
