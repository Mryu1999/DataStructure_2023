package I;

import java.util.Arrays;

/**
 * @Description:
 * @Author: Mryu_
 * @Date: 2023-10-25 12:00
 */

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {9, 2, 4, 7, 5, 1, 0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        boolean noSort = true;
        int length = arr.length - 1;
        for (; noSort; noSort = !noSort) {
            for (int i = 0; i < length; i++) {
                if (arr[i]<arr[i+1]){
                    int swp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = swp;
                    noSort = false;//检查本轮是否发生排序
                }
            }
        }
    }

}
