class Solution {
    public int maxProfit(int[] prices) {
       int bd = prices[0];
       int sd = prices[0];
       int profit = 0;
        
        
        for(int val: prices){
            if(val > sd){
                 sd = val;
            }
            else if(val < sd){
                profit += sd - bd;
                bd = sd = val;
            }
            
        }
        profit += sd - bd;
        
        return profit;
    }
}