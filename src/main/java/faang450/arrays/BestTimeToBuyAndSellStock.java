package faang450.arrays;

public class BestTimeToBuyAndSellStock {
//    You are given an array prices where prices[i] is the price of a given stock on the ith day.
//    You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
//    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
//
//    Example 1:
//        Input: prices = [7,1,5,3,6,4]
//        Output: 5
//        Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//        Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
//
//    Example 2:
//        Input: prices = [7,6,4,3,1]
//        Output: 0
//        Explanation: In this case, no transactions are done and the max profit = 0.
//
//
//    Constraints:
//        1 <= prices.length <= 105
//        0 <= prices[i] <= 104

    public static void main(String[] args) {
//        sol1();

//        int[] prices = {7, 1, 5, 3, 6, 4};
//        int[] prices = {7,6,4,3,1};
        int[] prices = {1,2};
        //find min element
        int minIndex = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[minIndex] > prices[i])
                minIndex = i;
        }
        System.out.println(minIndex);
        System.out.println(prices[minIndex]);

        int maxIndex = minIndex;
        for (int i = minIndex; i < prices.length; i++) {
            if (prices[maxIndex] < prices[i])
                maxIndex = i;
        }
        System.out.println(prices[maxIndex] - prices[minIndex]);
    }

    private static void sol1() {
        int[] prices = {7, 1, 5, 3, 6, 4};
//        int[] prices = {7,6,4,3,1};
//        int[] prices = {1,2};
        int maxProfit = 0;
        for (int i = prices.length-1; i >= 1; i--) {
            for (int j = i; j >= 0; j--) {
                int profit = prices[i] - prices[j];
                if (profit > maxProfit)
                    maxProfit = profit;
            }
        }
        System.out.println(maxProfit);
    }
}
