class Solution {
    public int search(int[] nums, int target) {
     
        int lo = 0;
        int hi = nums.length - 1;
        
        while(lo < hi){
           int mid = (lo + hi) / 2;
            
           if(nums[hi] > nums[mid])
               hi = mid;
           else
              lo = mid + 1;  
        }
        
        int rot = lo;
        
        int s1 = binarySearch(nums, 0, rot - 1, target);
        if(s1 != -1)
            return s1;
        
        int s2 = binarySearch(nums, rot, nums.length - 1, target);
        return s2;
        
    }
    
    public int binarySearch(int[] nums, int lo, int hi, int val){
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            
            if(val > nums[mid])
                lo = mid + 1;
            else if(val < nums[mid])
                hi = mid - 1;
            else
                return mid;
     
        }
          return -1;
    }
  
}