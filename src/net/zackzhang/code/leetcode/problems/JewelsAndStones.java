package net.zackzhang.code.leetcode.problems;

public class JewelsAndStones {

    public int solution(String J, String S) {
        char[] js = J.toCharArray();
        char[] ss = S.toCharArray();
        int count = 0;
        for (char j : js) {
            for (char s : ss) {
                if (j == s) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void test() {
        JewelsAndStones jas = new JewelsAndStones();
        System.out.println(jas.solution("aA", "aAAbbbb"));
    }
}
