package net.zackzhang.code.leetcode.problems;

/** 121# 买卖股票的最佳时机 */
public class BestTimeToBuyAndSellStock {

    private int solution(int[] prices) {
        // 需要找最小价格之后的最大价格，它们的差就是所求
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                // 注意，这里是 else if
                // 即如果 minPrice 更新了的话，这个分支是不会执行的
                // 保证了最大价格是 minPrice 之后的
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    public static void test() {
        System.out.println(new BestTimeToBuyAndSellStock().solution(new int[]{
                7, 1, 5, 3, 6, 4
        }));
    }
}
