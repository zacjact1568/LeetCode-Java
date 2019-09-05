package net.zackzhang.code.leetcode.problems;

import java.util.LinkedList;
import java.util.List;

/** 17# 电话号码的字母组合 */
public class LetterCombinationsOfAPhoneNumber {

    private static final String[] KEY_MAP = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private List<String> solution(String digits) {
        // 队列
        LinkedList<String> res = new LinkedList<>();
        if (digits.isEmpty()) return res;
        // 先放入空字符串
        res.offer("");
        // 观察规律，在 res 队头的字符串（str）长度刚好等于 digits 长度时组合完成
        while (!res.isEmpty() && (res.peek().length() != digits.length())) {
            String str = res.pop();
            // 观察规律，str 的长度刚好等于下一个数字的下标
            String key = KEY_MAP[digits.charAt(str.length()) - '0'];
            for (char ch : key.toCharArray()) {
                // 下一个数字对应的所有字母，和 str 拼接后入队
                res.offer(str + ch);
            }
        }
        return res;
    }

    public static void test() {
        System.out.println(new LetterCombinationsOfAPhoneNumber().solution("23"));
    }
}
