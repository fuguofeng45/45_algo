package run.fgf45.leetcode.search;

/**
 * 二分查找演变
 */
public class HalfSearchEvolution {

    /**
     * 查找最先相等的数字下标
     * @param data
     * @param target
     * @return
     */
    public static int halfSearchFirstEqual(int[] data, int target) {
        int left = 0;
        int right = data.length - 1;
        int middle = -1;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (target > data[middle]) {
                left = middle + 1;
            } else if (target < data[middle]) {
                right = middle - 1;
            } else {
                if (middle == 0 || data[middle - 1] < target) {
                    return middle;
                } else {
                    right = middle - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查询最后相等的数字下标
     * @param data
     * @param target
     * @return
     */
    public static int halfSearchLastEqual(int[] data, int target) {
        int left = 0;
        int right = data.length - 1;
        int middle = -1;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (target > data[middle]) {
                left = middle + 1;
            } else if (target < data[middle]) {
                right = middle - 1;
            } else {
                if (middle == data.length - 1 || data[middle + 1] > target) {
                    return middle;
                } else {
                    left = middle + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     * @param data
     * @param target
     * @return
     */
    public static int halfSearchFirstMoreTarget(int[] data, int target) {
        int left = 0;
        int right = data.length - 1;
        int middle = -1;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (target > data[middle]) {
                left = middle + 1;
            } else if (target <= data[middle]) {
                if(middle == 0 || data[middle - 1] < target){
                    return middle;
                }else{
                    right = middle - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     * @param data
     * @param target
     * @return
     */
    public static int halfSearchLastLessTarget(int[] data, int target) {
        int left = 0;
        int right = data.length - 1;
        int middle = -1;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (target >= data[middle]) {
                if(middle == data.length - 1 || data[middle + 1] > target){
                    return middle;
                }else{
                    left = middle + 1;
                }
            } else if (target < data[middle]) {
                right = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] data = {1,3,3,6,7,8,9,11,12,16,16};
        //System.out.println(halfSearchFirstEqual(data, 3));
        //System.out.println(halfSearchLastEqual(data, 16));
        System.out.println(halfSearchFirstMoreTarget(data, 12));
    }

}
