package run.fgf45.leetcode.sort;

import java.sql.SQLOutput;
import java.util.Arrays;

public class CountintSort {

    public static int [] doCountingSort(int[] data) {
        final int length = data.length;
        int [] sortResult = new int[length];

        if (length <= 1) {
            return data;
        }

        //find max data from array
        int max = data[0];
        for (int i = 1; i < length - 1; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }

        //init count array and assign
        int[] countArray = new int[max + 1];
        for (int i = 0; i < length ; i++) {
            ++countArray[data[i]];
        }

        //convert count array
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }

        //init sort result array and assign

        for (int i = length - 1; i >= 0; i--) {
            //Find this element should be indexed in the final sorted array
            int index = countArray[data[i]] - 1;
            sortResult[index] = data[i];
            countArray[data[i]]--;
        }

        //return result
        return sortResult;

    }

    public static void main(String[] args) {
        int [] data = {3,4,1,2,3,1,5,34,3};
        Arrays.stream(doCountingSort(data)).asLongStream().forEach(e -> {
            System.out.println(e);
        });
    }

}
