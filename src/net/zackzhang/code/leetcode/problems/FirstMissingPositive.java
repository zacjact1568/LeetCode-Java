package net.zackzhang.code.leetcode.problems;

/** 41# 缺失的第一个正数 */
public class FirstMissingPositive {

    private int solution(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            // 对于下标为 i 的元素
            // 若该元素在 (0, len] 区间内
            // 且没有在正确的位置（值为 k 的元素应该放在 k - 1 位置）
            // 就将值为 k 的元素（在 i 位置，即 nums[i] = k）与 k - 1（即 nums[i] - 1）位置的元素交换
            // 重复直到不满足条件，才考虑下一个 i
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                // 将 i 位置的元素与 nums[i] - 1 位置的元素交换
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        // 现在，nums 中存在的能放到正确位置上的元素都已经放到了对应的正确位置
        // 正确位置条件：值为 k 的元素应该放在 k - 1 位置
        // 即 k 位置应该放值为 k + 1 的元素
        // 因此，现在第一个不符合正确位置条件的下标 + 1 就是缺的第一个数
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                // 找到不符合条件的下标 i
                return i + 1;
            }
        }
        // 此时，说明 nums 中的数字都在正确的位置上
        // 说明 nums 中的数字是 1 到 len
        // len + 1 即为所求
        return len + 1;
    }

    public static void test() {
        System.out.println(new FirstMissingPositive().solution(new int[]{
                7, 8, 9, 11, 12
        }));
    }
}
