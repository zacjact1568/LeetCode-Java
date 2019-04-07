package net.zackzhang.code.leetcode.problems;

public class MaxIncreaseToKeepCitySkyline {

    public int solution(int[][] grid) {
        int maxHeight;
        // 横着看的最大值
        int[] horzMaxes = new int[grid.length];
        for (int i = 0; i < horzMaxes.length; i++) {
            maxHeight = 0;
            for (int height : grid[i]) {
                if (height > maxHeight) {
                    maxHeight = height;
                }
            }
            horzMaxes[i] = maxHeight;
        }
        // 竖着看的最大值
        int[] vertMaxes = new int[grid[0].length];
        for (int i = 0; i < vertMaxes.length; i++) {
            maxHeight = 0;
            for (int[] horzs : grid) {
                int height = horzs[i];
                if (height > maxHeight) {
                    maxHeight = height;
                }
            }
            vertMaxes[i] = maxHeight;
        }
        int increasedHeight = 0;
        int minHeight, horzMax, vertMax;
        for (int i = 0; i < horzMaxes.length; i++) {
            for (int j = 0; j < vertMaxes.length; j++) {
                // 找出某个位置横向最大值和竖向最大值中较小的那个，为 minHeight
                horzMax = horzMaxes[i];
                vertMax = vertMaxes[j];
                if (horzMax < vertMax) {
                    minHeight = horzMax;
                } else {
                    minHeight = vertMax;
                }
                // 该位置最多能增高到的高度就是 minHeight
                increasedHeight += minHeight - grid[i][j];
            }
        }
        return increasedHeight;
    }

    public int solution2(int[][] grid) {
        // 横向最大值
        int[] horzMaxes = new int[grid.length];
        // 竖向的最大值
        int[] vertMaxes = new int[grid[0].length];
        int height;
        for (int i = 0; i < horzMaxes.length; i++) {
            for (int j = 0; j < vertMaxes.length; j++) {
                height = grid[i][j];
                // 同时更新横向最大值和竖向最大值
                if (height > horzMaxes[i]) {
                    horzMaxes[i] = height;
                }
                if (height > vertMaxes[j]) {
                    vertMaxes[j] = height;
                }
            }
        }
        int increasedHeight = 0;
        int minHeight;
        for (int i = 0; i < horzMaxes.length; i++) {
            for (int j = 0; j < vertMaxes.length; j++) {
                // 找出某个位置横向最大值和竖向最大值中较小的那个，为 minHeight
                if (horzMaxes[i] < vertMaxes[j]) {
                    minHeight = horzMaxes[i];
                } else {
                    minHeight = vertMaxes[j];
                }
                // 该位置最多能增高到的高度就是 minHeight
                increasedHeight += minHeight - grid[i][j];
            }
        }
        return increasedHeight;
    }

    public static void test() {
        MaxIncreaseToKeepCitySkyline mitkcs = new MaxIncreaseToKeepCitySkyline();
        System.out.println(mitkcs.solution2(new int[][]{{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}}));
    }
}
