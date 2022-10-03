class Solution {
    public int change(int amount, int[] coins) {
        
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        
        for(int val: coins){
            for(int i = 1; i < dp.length; i++){
                if(i >= val){
                    
                    if(dp[i - val] > 0)
                        dp[i] += dp[i - val];
                }
            }
        }
        
        return dp[dp.length - 1];
    }
}