class Solution {
    public int maxProfit(int[] prices) {
        //max profit selling today
        int[] mpst = new int[prices.length];
        
        //max profit buying today
        int[] mpbt = new int[prices.length];
        
        int lsf = Integer.MAX_VALUE;
        int msp = Integer.MIN_VALUE;
        
        for(int i = 0; i < prices.length; i++){
             if(prices[i] < lsf)
                  lsf = prices[i];
            
             int pist = prices[i] - lsf;
             mpst[i] = Math.max(pist, msp);
             msp = Math.max(pist, msp);
        }
        
        int msf = Integer.MIN_VALUE;
        int mbp = Integer.MIN_VALUE;
        
        for(int i = prices.length - 1; i >= 0; i--){
            if(prices[i] > msf)
                  msf = prices[i];
            int pibt = msf - prices[i];
            mpbt[i] = Math.max(pibt, mbp);
            mbp = Math.max(mbp, pibt);
        }
    int max = Integer.MIN_VALUE;
    for(int i = 0; i < prices.length; i++){
        mpbt[i] += mpst[i];
        max = Math.max(mpbt[i], max);
    }
        
    return max;
    }
}