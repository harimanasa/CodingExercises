//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        int min_so_far = Integer.MAX_VALUE;
        int last_profit = 0;

        for(int price:prices){
            min_so_far = Math.min(min_so_far, price);
            profit = Math.max(profit, price-min_so_far);
        }
        
        return profit;
    }
}