package I;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:关于最长公共子序列问题的研究
 * @Author: Mryu_
 * @Date: 2023-10-26 16:21
 */

public class LongCommonSubsequence {
    public static void main(String[] args) {
        String a = "program";
        String b = "algorithm";
        List<Character> list1 = a.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Character> list2 = b.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        // 递归
        System.out.println(recursiveLongCommonSubseq(list1, list1.size(), list2, list2.size()));
        // 递归+制表备查
        memo = new int[list1.size() + 1][list2.size() + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        System.out.println(recursiveLSCByMemo(list1, list1.size(), list2, list2.size()));
        print2DArray(memo);
        // 动态规划
        System.out.println(lscDynamic(list1, list2));
    }

    /**
     * 递归实现
     * 主要依靠减而治之和分而治之
     * 时间复杂度：当两父序列长度相等时 O(2^n)
     *
     * @param a
     * @param b
     * @return
     */
    private static int recursiveLongCommonSubseq(List<Character> a, int aSize, List<Character> b, int bSize) {
        if (aSize < 1 || bSize < 1) {
            return 0;
        }
        if (a.get(aSize - 1).equals(b.get(bSize - 1))) {
            return 1 + recursiveLongCommonSubseq(a, aSize - 1, b, bSize - 1);
        } else {
            return Math.max(recursiveLongCommonSubseq(a, aSize - 1, b, bSize), recursiveLongCommonSubseq(a, aSize, b, bSize - 1));
        }
    }

    // 备忘录，消除重复子问题
    private static int[][] memo;

    /**
     * 在递归的基础上引入备忘录，以解决重复子问题
     *
     * @param a
     * @param aSize
     * @param b
     * @param bSize
     * @return
     */
    private static int recursiveLSCByMemo(List<Character> a, int aSize, List<Character> b, int bSize) {
        if (aSize < 1 || bSize < 1) {
            return 0;
        }
        if (memo[aSize][bSize] != -1) {
            return memo[aSize][bSize];
        }
        if (a.get(aSize - 1).equals(b.get(bSize - 1))) {
            memo[aSize][bSize] = 1 + recursiveLSCByMemo(a, aSize - 1, b, bSize - 1);
        } else {
            memo[aSize][bSize] = Math.max(recursiveLSCByMemo(a, aSize - 1, b, bSize), recursiveLSCByMemo(a, aSize, b, bSize - 1));
        }
        return memo[aSize][bSize];
    }

    /**
     * 迭代：利用动态规划实现 时间复杂度O(m*n)
     *
     * @param a
     * @param b
     * @return
     */
    private static int lscDynamic(List<Character> a, List<Character> b) {
        int[][] dp = new int[a.size() + 1][b.size() + 1];
        for (int i = 1; i <= a.size(); i++) {
            for (int j = 1; j <= b.size(); j++) {
                if (a.get(i - 1).equals(b.get(j - 1))) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        System.out.println("------------lscDynamic------------");
        print2DArray(dp);
        return dp[a.size()][b.size()];
    }

    /**
     * 格式化打印二维数组
     *
     * @param memo
     */
    private static void print2DArray(int[][] memo) {
        for (int[] row : memo) {
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i] == -1 ? "-1 " : " " + row[i] + " ");
            }
            System.out.println();
        }
    }
}
