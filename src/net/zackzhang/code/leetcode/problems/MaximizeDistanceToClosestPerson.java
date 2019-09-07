package net.zackzhang.code.leetcode.problems;

import java.util.ArrayList;

/** 849# 到最近的人的最大距离 */
public class MaximizeDistanceToClosestPerson {

    private int solution(int[] seats) {
        // 在 seats 两边补 1，为 seatList
        ArrayList<Integer> seatList = new ArrayList<>();
        seatList.add(1);
        for (int seat : seats) {
            seatList.add(seat);
        }
        seatList.add(1);
        // 计算 seatList 中两个 1 之间的最大间隔 maxInterval1
        int maxInterval1 = 0, tempInterval = 0;
        for (int seat : seatList) {
            if (seat == 0) {
                tempInterval++;
            } else {
                maxInterval1 = Math.max(maxInterval1, tempInterval);
                tempInterval = 0;
            }
        }
        // 计算如果坐到第一个位置，距离最近的 1 的间隔 maxInterval2
        int maxInterval2 = 0;
        while (seats[maxInterval2] == 0) {
            maxInterval2++;
        }
        // 计算如果坐到最后一个位置，距离最近的 1 的间隔 maxInterval3
        int maxInterval3 = 0;
        while (seats[seats.length - 1 - maxInterval3] == 0) {
            maxInterval3++;
        }
        // 最终结果是 (maxInterval1 + 1) / 2、maxInterval2、maxInterval3 三者最大的
        return Math.max((maxInterval1 + 1) / 2, Math.max(maxInterval2, maxInterval3));
    }

    public static void test() {
        System.out.println(new MaximizeDistanceToClosestPerson().solution(new int[]{
                1, 0, 0, 0, 1, 0, 1
        }));
    }
}
