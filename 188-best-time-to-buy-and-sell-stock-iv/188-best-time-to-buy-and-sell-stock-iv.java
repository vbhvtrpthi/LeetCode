class Solution {
    public int maxProfit(int t, int[] prices) {
        
        int[][] dp = new int[t + 1][prices.length];
        
        for(int k = 1; k < dp.length; k++){
            int max = Integer.MIN_VALUE;    
            for(int d = 1; d < prices.length; d++){
                 if(dp[k - 1][d - 1]  -  prices[d - 1] > max)
                     max = dp[k - 1][d - 1] - prices[d - 1];
                
                dp[k][d] = Math.max(dp[k][d - 1], max + prices[d]);
            }
        }
        
        return prices.length >= 2 ? dp[t][prices.length - 1] : 0;
    }
}