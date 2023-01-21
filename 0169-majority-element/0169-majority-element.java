class Solution {
    public int majorityElement(int[] nums) {
        int me = nums[0];
        int count = 1;
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == me){
                count++;
            }else{
                if(count == 0){
                    me = nums[i];
                    count++;
                }else{
                    count--;
                }
            }
        }
        
        return me;
        
    }
}