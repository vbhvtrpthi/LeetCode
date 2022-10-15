class Solution {
    public int maxChunksToSorted(int[] arr) {
        
        int chunks = 0;
        int maxsf = Integer.MIN_VALUE;
        
        for(int i = 0; i < arr.length; i++){
            maxsf = Math.max(maxsf, arr[i]);
            
            if(maxsf == i)
                chunks++;
        }
        
        return chunks;
    }
}