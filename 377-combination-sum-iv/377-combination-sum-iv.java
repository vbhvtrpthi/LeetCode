class Solution {
    public int combinationSum4(int[] nums, int target) {
        
        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        for(int i = 1; i < dp.length; i++){
            for(int val: nums){
                 if(i >= val){
                     if(dp[i - val] > 0)
                          dp[i] += dp[i - val];
                 }
            }
        }
        
        return dp[dp.length - 1];
    }
}