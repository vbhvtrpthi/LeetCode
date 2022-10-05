class Solution {
    public int maxProfit(int[] prices, int fee) {
        
        int bsp = -prices[0];
        int ssp = 0;
        
        for(int val = 1; val < prices.length; val++){
            int nbsp = ssp - prices[val];
            int nssp = prices[val] + bsp - fee;
            
            bsp = Math.max(bsp, nbsp);
            ssp = Math.max(nssp, ssp);
        }
        
        return ssp;
    }
}