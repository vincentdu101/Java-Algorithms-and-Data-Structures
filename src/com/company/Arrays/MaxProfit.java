package com.company.Arrays;

/*

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an
algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.

*/
public class MaxProfit {

    public MaxProfit() {}

    public int maxProfit(int[] prices) {
        // base case
        if (prices.length == 0) {
            return 0;
        }

        // find the max profit
        return determineMax(0, 0, prices);
    }

    public int determineMax(int profit, int day, int[] prices) {
        // if there are more days left, exit with the profit saved
        if (day == prices.length) {
            return profit;
        }

        int buy = prices[day];
        // for each day see if we bought it and sold it in some
        // future date in the list if that profit is bigger
        // than the profit we've saved so far
        for (int x = day + 1; x < prices.length; x++) {
            int sell = prices[x];

            // if we sell on this date and the profit is bigger
            // than the previous saved date, overwrite the profit
            if (sell - buy > profit) {
                profit = sell - buy;
            }
        }

        // recurse with incrementing the next day as the
        // day we buy
        return determineMax(profit, day + 1, prices);
    }

}
