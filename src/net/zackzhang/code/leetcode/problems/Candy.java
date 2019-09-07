package net.zackzhang.code.leetcode.problems;

import java.util.Arrays;

/** 135# 分发糖果 */
public class Candy {

    private int solution(int[] ratings) {
        // nums 代表给每个孩子分发糖果的个数
        int[] nums = new int[ratings.length];
        // 初始化为全 1
        Arrays.fill(nums, 1);
        // 第一遍，由前往后遍历
        // 如果下一个孩子（i + 1）比这一个孩子（i）评分高，下一个孩子的糖果在这一个孩子的基础上加 1
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i] < ratings[i + 1]) {
                nums[i + 1] = nums[i] + 1;
            }
        }
        // 第二遍，由后往前遍历
        // 如果下一个孩子（i - 1）比这一个孩子（i）评分高
        // 如果下一个孩子的糖果已经比这一个孩子高了，不变
        // 否则在这一个孩子的基础上加 1
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i] < ratings[i - 1]) {
                nums[i - 1] = Math.max(nums[i - 1], nums[i] + 1);
            }
        }
        // 此时 nums 中的元素就是最终分发方案，求和即可
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public static void test() {
        System.out.println(new Candy().solution(new int[]{
                1, 0, 2
        }));
    }
}
