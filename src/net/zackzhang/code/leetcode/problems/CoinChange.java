package net.zackzhang.code.leetcode.problems;

import java.util.Arrays;

/** 322# 零钱兑换 */
public class CoinChange {

    // 动态规划（自底向上）
    private int solution(int[] coins, int amount) {
        // nums[i] 代表凑 i 块钱需要的最少硬币数
        // i 可取 0 ~ amount，因此其大小是 amount + 1
        int[] nums = new int[amount + 1];
        // nums 都初始化为需要的最多硬币数（即不可能达到的数量）
        Arrays.fill(nums, amount + 1);
        // 凑 0 块钱不需要硬币，因此设为 0
        nums[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                // 对于每种面额（coin）的硬币
                if (coin <= i) {
                    // 只考虑面值不大于 i 的硬币
                    // 凑 i 块钱需要的最少硬币数等于
                    // 不取 coin（nums[i]）和
                    // 取 coin（nums[i - coin] + 1）的较小者
                    nums[i] = Math.min(nums[i], nums[i - coin] + 1);
                }
            }
        }
        // 如果 nums[amount] > amount，说明无法凑齐，返回 -1
        // 实际上 nums[amount] > amount 可改为 nums[amount] == amount + 1
        // 因为 amount + 1 是 nums 中能存在的最大元素
        return nums[amount] > amount ? -1 : nums[amount];
    }

    // 动态规划（自顶向下）
    private int solution2(int[] coins, int amount) {
        if (amount < 1) return 0;
        return solution2(coins, amount, new int[amount]);
    }

    // 返回凑齐 amount 需要的最少硬币数
    // nums[i - 1] 代表凑 i 块钱需要的最少硬币数
    private int solution2(int[] coins, int amount, int[] nums) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        // 如果凑齐 amount 需要的最少硬币数已计算过（≠ 0），直接返回
        if (nums[amount - 1] != 0) return nums[amount - 1];
        // 计算 amount 减去各种硬币价值（coin）需要的最少硬币数（递归），再 + 1
        int num = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = solution2(coins, amount - coin, nums);
            if (res >= 0 && res < num) {
                num = res + 1;
            }
        }
        // 如果可以凑齐，将结果放入 nums
        nums[amount - 1] = num == Integer.MAX_VALUE ? -1 : num;
        return nums[amount - 1];
    }

    public static void test() {
        System.out.println(new CoinChange().solution(
                new int[]{1, 2, 5},
                11
        ));
    }
}
