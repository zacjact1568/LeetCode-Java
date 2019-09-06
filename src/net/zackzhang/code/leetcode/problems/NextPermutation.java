package net.zackzhang.code.leetcode.problems;

import java.util.Arrays;

/** 31# 下一个排列 */
public class NextPermutation {

    private void solution(int[] nums) {
        // 从后往前寻找第一个变小的位置 a
        int a = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                a = i - 1;
                break;
            }
        }
        if (a >= 0) {
            // 从后往前寻找第一个大于 nums[a] 的位置 b
            // 由于 a 后的数字都是降序的，就相当于从 a 往后找刚好大于 nums[a] 的位置 b
            int b = nums.length - 1;
            for (int i = nums.length - 1; i > a; i--) {
                if (nums[i] > nums[a]) {
                    b = i;
                    break;
                }
            }
            // 交换 a、b 位置的元素
            swap(nums, a, b);
        }
        // 如果 a == -1，则说明原数组降序排列，不存在下一个更大的排列，直接进入排序
        // 将 a 后面的元素冒泡排序
        for (int i = nums.length - 1; i > a + 1; i--) {
            for (int j = a + 1; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    private void swap(int[] nums, int num1, int num2) {
        int temp = nums[num1];
        nums[num1] = nums[num2];
        nums[num2] = temp;
    }

    public static void test() {
        int[] nums = new int[]{3, 5, 8, 7, 6, 4};
        new NextPermutation().solution(nums);
        System.out.println(Arrays.toString(nums));
    }
}
