package net.zackzhang.code.leetcode.problems;

public class PalindromeNumber {

    public boolean solution(int x) {
        // 0 是回文
        if (x == 0) return true;
        // 排除负数
        if (x < 0) return false;
        // 排除结尾为 0 的正数
        if (x % 10 == 0) return false;
        // 其他正数
        // 将各位数取出，放到一个数组里
        // 32 位整型数最多 10 位
        int[] digits = new int[10];
        int quotient = x;
        int i = 0;
        while (quotient != 0) {
            digits[i++] = quotient % 10;
            quotient /= 10;
        }
        // i 为结尾下标
        i--;
        // j 为起始下标
        int j = 0;
        while (j < i) {
            // 若下标为 i、j 的元素不相等
            // j 后移，i 前移
            if (digits[j++] != digits[i--]) return false;
        }
        return true;
    }

    public static void test() {
        PalindromeNumber pn = new PalindromeNumber();
        System.out.println(pn.solution(123321));
    }
}
