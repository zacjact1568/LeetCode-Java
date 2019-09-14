package net.zackzhang.code.leetcode.problems;

import java.util.Arrays;

/** 62# 不同路径 */
public class UniquePaths {

    private int solution(int m, int n) {
        // nums[i][j] 表示 i×j 格子的路径数
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    // 如果是单行或单列，只有 1 条路径
                    nums[i][j] = 1;
                } else {
                    nums[i][j] = nums[i - 1][j] + nums[i][j - 1];
                }
            }
        }
        return nums[m - 1][n - 1];
    }

    private int solution2(int m, int n) {
        // 由于在上述方法中
        // nums[i][j] 只与 nums[i - 1][j]（上）和 nums[i][j - 1]（左）的数据有关
        // 因此只需保存上一行的数据即可，左边的数据使用刚计算出来的
        // 在内层 for 中，上一行的数据逐渐被替换成这一行的数据
        int[] nums = new int[n];
        Arrays.fill(nums, 1);
        for (int i = 1; i < m; i++) {
            // 此时，nums 表示 i - 1 行的数据
            for (int j = 1; j < n; j++) {
                // nums[j] 表示上边还未替换的数据
                // nums[j - 1] 表示左边已替换的数据
                // 将它们相加，赋值给 nums[j]，完成当前数据的替换
                nums[j] += nums[j - 1];
            }
            // 此时，nums 表示 i 行的数据
        }
        return nums[n - 1];
    }

    public static void test() {
        System.out.println(new UniquePaths().solution(3, 2));
    }
}
