class Solution {
    public int numTrees(int n) {
      
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++){
            for(int j = 0; j < i; j++){
                int right = i - j - 1;
                int val = (dp[j] * dp[right]);
                dp[i] = dp[i] + val;
            }
        }
        
        return dp[n];
    }
}