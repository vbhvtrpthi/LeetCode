class Solution {
    public int maxProfit(int[] prices) {
        
        int bsp = -prices[0];
        int ssp = 0;
        int csp = 0;
        
        for(int i = 1; i < prices.length; i++){
            int nbsp = csp - prices[i];
            int nssp = bsp + prices[i];
            int ncsp = ssp;
            
            bsp = Math.max(bsp, nbsp);
            ssp = Math.max(ssp, nssp);
            csp = Math.max(csp, ncsp);
            
            // System.out.println(bsp + " " + ssp + " " + csp);
        }
        
        return ssp;
        
    }
}