package I;

import java.util.Arrays;

/**
 * @Description:
 * @Author: Mryu_
 * @Date: 2023-10-25 14:38
 */

public class RecursiveExercise {
    public static void main(String[] args) {
        int[] intArr = {1, 2, 3, 4, 5, 6, 7};
        int[] intArr2 = {1, 2, 3, 4, 5, 6};
        int[] intArr3 = {1};
        int sum = linearRecursiveSum(intArr, intArr.length);
        System.out.println(sum);
        arrReverseByIterator(intArr);
//        arrReverse(intArr, 0, intArr.length-1);
        arrReverse(intArr2, 0, intArr2.length - 1);
        arrReverse(intArr3, 0, intArr3.length - 1);
        System.out.println(Arrays.toString(intArr));
        System.out.println(Arrays.toString(intArr2));
        System.out.println(Arrays.toString(intArr3));
    }

    /**
     * 使用迭代将数组颠倒
     *
     * @param intArr
     */
    private static void arrReverseByIterator(int[] intArr) {
        int lo = 0;
        int hi = intArr.length - 1;
        while (lo < hi) {
            swap(intArr,lo++,hi--);
        }
    }

    private static void swap(int[] intArr, int i, int i1) {
        int temp = intArr[i];
        intArr[i] = intArr[i1];
        intArr[i1] = temp;
    }


    /**
     * 用递归的方式将数组颠倒
     *
     * @param intArr
     * @param lo
     * @param hi
     */
    private static void arrReverse(int[] intArr, int lo, int hi) {
        if (lo < hi) {
            swap(intArr,lo++,hi--);
            arrReverse(intArr, lo, hi);
        }
    }

    /**
     * 数组求和：线性递归
     *
     * @param intArr
     * @param n
     * @return
     */
    private static int linearRecursiveSum(int[] intArr, int n) {
        return n < 1 ? 0 : linearRecursiveSum(intArr, n - 1) + intArr[n - 1];
    }
}
