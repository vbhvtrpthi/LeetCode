class Solution {
    public int change(int amount, int[] coins) {
        
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        
        for(int val: coins){
            for(int a = 0; a <= amount; a++){
                if(a >= val){
                    dp[a] += dp[a - val];
                }
            }
        }
        
        return dp[amount];
    }
}