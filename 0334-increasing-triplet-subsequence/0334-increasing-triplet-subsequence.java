class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        int small = Integer.MAX_VALUE, big =  Integer.MAX_VALUE;
        for(int val: nums){
            if(val <= small){
                small = val;
            }else if(val <= big){
                big = val;
            }else{
                return true;
            }
        }
        
        return false;
    }
}