package net.zackzhang.code.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 15# 三数之和 */
public class ThreeSum {

    private List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        // 对于 i 位置的数，在它后面的数中选其他两个数
        for (int i = 0; i < nums.length; i++) {
            // 如果当前数已经大于 0
            // 那么后面的数都大于 0，相加不可能等于 0 了，结束循环
            if (nums[i] > 0) break;
            // 如果 i 位置的数和它前面的数（i - 1）相等
            // 不计算以避免重复
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // left 和 right 分别是其他两个数的位置
            // 初始化为 i 之后元素的首位和末位
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    // 找到一组
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // left 之后可能有连续相同的数
                    // 为避免得到重复的三元组
                    // left 移至相同数区域的最后一个数
                    // 后面还要再后移一位，就移到了不相同的数上
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                    // 同理，right 移至相同数区域的最前一个数
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                } else if (sum < 0) {
                    // 和小了，left 后移以增大和
                    left++;
                } else {
                    // sum > 0
                    // 和大了，right 前移以减小和
                    right--;
                }
            }
        }
        return res;
    }

    public static void test() {
        System.out.println(new ThreeSum().solution(new int[]{
                -1, 0, 1, 2, -1, -4
        }));
    }
}
