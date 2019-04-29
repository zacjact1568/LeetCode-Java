package net.zackzhang.code.leetcode.problems;

public class RemoveOutermostParentheses {

    public String solution(String S) {
        // 由于需要频繁删除字符串中的字符，用 StringBuilder
        StringBuilder sb = new StringBuilder(S);
        // 标志
        int flag = 0;
        // 每个元分解的起始下标
        int start = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                // 左括号 + 1
                flag++;
            } else {
                // 右括号 - 1
                flag--;
            }
            // flag 为 0 时说明已遍历完一个元分解
            if (flag == 0) {
                // 删除首尾两个括号，同时减小遍历索引 i
                sb.deleteCharAt(start);
                i--;
                sb.deleteCharAt(i--);
                // 更新 start 为下一个元分解的起始下标
                start = i + 1;
            }
        }
        return sb.toString();
    }

    public static void test() {
        System.out.println(new RemoveOutermostParentheses().solution("(()())(())"));
    }
}
