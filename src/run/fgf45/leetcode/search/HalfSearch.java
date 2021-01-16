package run.fgf45.leetcode.search;

public class HalfSearch {

    /**
     * 二分查找
     * @param data
     * @param left
     * @param right
     * @param target
     * @return
     */
    public static int search(int [] data, int left, int right, int target){
        int middle = -1;
        while(left <= right){
            middle = left + (right - left) / 2;
            if(data[middle] == target){
                return middle;
            }else if(data[middle] > target){
                right = middle - 1;
            }else if(data[middle] < target){
                left = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] data = {1, 3, 6, 7, 9, 10, 11, 32, 3431};
        System.out.println(search(data, 0, data.length, 10));
    }

}
