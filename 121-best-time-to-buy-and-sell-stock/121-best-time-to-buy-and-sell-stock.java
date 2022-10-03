class Solution {
    public int maxProfit(int[] prices) {
        
        int lsf = Integer.MAX_VALUE;
        int op = Integer.MIN_VALUE;
        for(int val: prices){
            if(val < lsf)
                lsf = val;
            
            int pist = val - lsf;
            op = Math.max(op, pist);
        }
        
        return op;
    }
}