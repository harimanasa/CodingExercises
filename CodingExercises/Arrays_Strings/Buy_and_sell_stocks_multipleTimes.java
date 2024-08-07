//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    
        public int maxProfit(int[] prices) {
            /*** You just need the sum of all positive differences */
    
            /** scan the array once and find all pairs of elements in ascending order */
    
            int profit = 0;
    
            for(int i=1; i<prices.length; i++){
                if(prices[i] > prices[i-1]) profit+=prices[i]-prices[i-1];
            }
            return profit;
        }

    public int maxProfitUsingPeakValley(int[] prices) {
        //Intuition: at any point(price), we want to know
        // the sum of positive differences (peak-valley) till that point
        // because that would be the maximum

        /** For that, we initiate peak and valley will be initially the same, but when 
        there's price that is > peak, peak will be set to price. 
        
        This part is tricky:
        Otherwise means this new price is also a dip. But we need to have it as a local minimum. So, we save global minimum into total and then have the local minimum running.
        So the positive difference between (peak and valley) will be added to the total; 
        and peak and valley have to the current dip. ' */

        int total = 0;
        int valley, peak;
        valley = peak = Integer.MAX_VALUE;

        for(int price: prices){
            if(price<peak){
                total+= peak-valley; 
                valley = peak = price; //resetting valley and price
            } else {
                peak = price;
            }
        }
        total+=peak-valley;
        return total;
    }
}