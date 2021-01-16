package run.fgf45.leetcode.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    public static void mergeSort(int [] data){
        mergeSortInternally(data, 0, data.length - 1);
    }

    public static void mergeSortInternally(int [] data, int left, int right){
        if(left >= right){
            System.out.println(data[left]);
            return;
        }
        int middle = left + (right - left) / 2;
        mergeSortInternally(data, left, middle);
        mergeSortInternally(data, middle + 1, right);

        //mergeSort(data, left, middle, right);
    }

    public static void mergeSort(int [] data, int left, int middle, int right){
        int index = 0;
        int [] tmp = new int[right - left + 1];
        int tmpRight = middle + 1;
        int tmpLeft = left;
        while(tmpLeft <= middle && tmpRight <= right){
            if(data[tmpLeft] <= data[tmpRight]){
                tmp[index++] = data[tmpLeft++];
            }else{
                tmp[index++] = data[tmpRight++];
            }
        }
        while(tmpLeft <= middle){
            tmp[index++] = data[tmpLeft++];
        }
        while(tmpRight <= right){
            tmp[index++] = data[tmpRight++];
        }
        for (int i = 0; i < tmp.length; i++) {
            data[left++] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int [] data = {1,3,5,6,4,2,9,0,8,745432123};
        mergeSort(data);
        /*Arrays.stream(data).asLongStream().forEach(d -> {
            System.out.println(d);
        });*/
    }

}
