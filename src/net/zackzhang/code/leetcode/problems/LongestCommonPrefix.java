package net.zackzhang.code.leetcode.problems;

/** 14# 最长公共前缀 */
public class LongestCommonPrefix {

    private String solution(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        // 用第一个字符串作参考
        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (String str : strs) {
                // 如果中途发现某个字符串已经遍历到结尾
                // 或未到结尾，但 i 位置已经不同了
                // 结束遍历
                if (i == str.length() || str.charAt(i) != ch) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void test() {
        System.out.println(new LongestCommonPrefix().solution(new String[]{
                "flower", "flow", "flight"
        }));
    }
}
