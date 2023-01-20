class Solution {

    public int maxArea(int[] height) {
        int li = 0;
        int ri = height.length - 1;
        int maxi = Integer.MIN_VALUE;

        while (li < ri) {
            if (height[ri] < height[li]) {
                maxi = Math.max(maxi, height[ri] * (ri - li));
                ri--;
            }else{
                maxi = Math.max(maxi, height[li] * (ri - li));
                li++;
            }
            
        }
        
        return maxi;
    }
}
