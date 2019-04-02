package net.zackzhang.code.leetcode.problems;

public class StringToInteger {

    public int solution(String str) {
        char[] chars = str.toCharArray();
        // 结果
        int result = 0;
        // 是否有结果
        boolean hasResult = false;
        // 负数
        boolean isNegative = false;
        // 是否已确定正负
        boolean isSigned = false;
        // 遍历字符数组
        for (char ch : chars) {
            // 对于后续所有字符
            if (!isSigned) {
                // 如果还未确定正负（其实就是指空白字符后跟的第一个字符，该字符不可能为空白）
                if (ch == ' ') {
                    // 跳过开始的空白字符
                    continue;
                } else if (ch == '-') {
                    // 遇到负号，则为负数
                    isNegative = true;
                } else if (ch >= '0' && ch <= '9') {
                    // 遇到数字，则为正数
                    result = ch - 48;
                    hasResult = true;
                } else if (ch != '+') {
                    // 遇到除正号的其他字符，不合法
                    return 0;
                }
                isSigned = true;
            } else {
                // 如果已确定正负（其实就是指空白字符后跟的第二个字符及以后的所有字符，必须为数字）
                if (ch >= '0' && ch <= '9') {
                    if (!hasResult) {
                        hasResult = true;
                    }
                    int digit = ch - 48;
                    // 为什么不先当正数算，最后再取反？
                    // 因为最大正数的相反数比最小负数大 1，多出来的最小负数（-2147483648）不好判断
                    if (isNegative) {
                        // 负数
                        if (result < (Integer.MIN_VALUE + digit) / 10) {
                            // 下溢
                            result = Integer.MIN_VALUE;
                            break;
                        } else {
                            result = result * 10 - digit;
                        }
                    } else {
                        // 正数
                        if (result > (Integer.MAX_VALUE - digit) / 10) {
                            // 上溢
                            result = Integer.MAX_VALUE;
                            break;
                        } else {
                            result = result * 10 + digit;
                        }
                    }
                } else if (hasResult) {
                    // 出现非数字，但 result 被修改过
                    break;
                } else {
                    // 出现非数字，但 result 未被修改过
                    return 0;
                }
            }
        }
        return result;
    }

    public static void test() {
        StringToInteger sti = new StringToInteger();
        System.out.println(sti.solution("2147483646"));
    }
}
