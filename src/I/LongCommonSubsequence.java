package I;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:关于最长公共子序列问题的研究
 * @Author: Mryu_
 * @Date: 2023-10-26 16:21
 */

public class LongCommonSubsequence {
    public static void main(String[] args) {
        String a = "educational";
        String b = "advantage";
        List<Character> list1 = a.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Character> list2 = b.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        int result = recursiveLongCommSubseq(list1, list1.size(), list2, list2.size());
        System.out.println(resultList);
        System.out.println(result);
    }

    /**
     * 递归实现
     * 主要依靠减而治之和分而治之
     *
     * @param a
     * @param b
     * @return
     */
    private static List<Character> resultList = new ArrayList<>();

    private static int recursiveLongCommSubseq(List<Character> a, int aSize, List<Character> b, int bSize) {
        System.out.println(aSize+":"+bSize);
        if (aSize < 1 || bSize < 1) {
            return 0;
        }
        if (a.get(aSize - 1).equals(b.get(bSize - 1))) {
            resultList.add(a.get(aSize - 1));
            return 1+ recursiveLongCommSubseq(a, aSize-1, b, bSize-1);
        } else {
            return Math.max(recursiveLongCommSubseq(a, aSize-1, b, bSize),recursiveLongCommSubseq(a, aSize, b, bSize-1));
//            if (a.contains(b.get(bSize - 1))) {
//                resultList.add(b.get(bSize - 1));
//                recursiveLongCommSubseq(a.subList(0, a.lastIndexOf(b.get(bSize - 1))), a.size(), b, b.size());
//            }
//            if (b.contains(a.get(aSize - 1))) {
//                resultList.add(a.get(aSize - 1));
//                recursiveLongCommSubseq(a, list1.size(), b.subList(0, b.lastIndexOf(a.get(bSize - 1))), list2.size());
//            }
        }
    }


}
