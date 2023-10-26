package I;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Description: 研究关于斐波那契数列不同实现的复杂度和空间
 * 自顶而下为递归，自底而上为迭代
 * @Author: Mryu_
 * @Date: 2023-10-26 10:41
 */

public class FibSequence {
    public static void main(String[] args) {
        long fibNum = 40;
//        long result = recursiveFib(fibNum);
//        System.out.println(result);
        long result2 = recursiveMemoizationFib(fibNum);
        System.out.println(result2);
        long result3 = iteratorFib(fibNum);
        System.out.println(result3);

    }

    /**
     * 改进迭代将已计算过的结果制表备查
     *
     * @param n
     * @return
     */
    private static Map fibMap = new HashMap<Integer, Integer>();
    private static long recursiveMemoizationFib(long n) {
        if (n < 2) {
            return n;
        }
        if (Objects.isNull(fibMap.get(n))) {
            fibMap.put(n,recursiveMemoizationFib(n - 1) + recursiveMemoizationFib(n - 2));
        }
        return (long)fibMap.get(n);
    }

    /**
     * 利用迭代方式求解斐波那契数列
     * 思路：从小到大去求解
     * 时间复杂度为O(n)
     * 空间复杂度为O(1)
     *
     * @param n
     * @return
     */
    private static long iteratorFib(long n) {
        long a = 0;
        long b = 1;
        while (0< n--) {
            a = a + b;
            b = a - b;
        }
        return a;
    }

    /**
     * 利用递归实现斐波那契数列计算
     * fib(n) = fib(n-1) + fib(n-2)
     * 复杂度：下界：T(0) = T(1) = 1;
     * 上界：T(n) = T(n-1) + T(n-2) + 1 (1代表fib(n)中加法运算的固定时间)
     * 令：S(n) = [T(n)+1]/2
     * 则:S(0) = [T(0)+1]/2 = 1 = fib(1); S(1) = [T(1)+1]/2 = 1 = fib(2)
     * 故：S(n) = S(n-1) + S(n-2) = fib(n+1)
     * T(n) = 2*S(n) - 1 = 2*fib(n+1) - 1 = O(fib(n+1)) = O(((1+√5)/2)^n) ≈ 1.618^n
     * 同时因为无法对多个重复子结果进行复用，所以空间上也有极高的复杂度,可以通过记忆查表法来降低复杂度
     *
     * @param n
     * @return
     */
    private static long recursiveFib(long n) {
        return (n < 2) ? n : recursiveFib(n - 1) + recursiveFib(n - 2);
    }
}
