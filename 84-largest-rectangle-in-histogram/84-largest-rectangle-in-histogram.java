class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int[] nser = nserf(heights);
        int[] nsel = nself(heights);
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < heights.length; i++){
            int width = nser[i] - nsel[i] - 1;
            max = Math.max(max, width * heights[i]);
        }
        
        return max;
    }
    
    public static int[] nserf(int[] heights){
        int[] nser = new int[heights.length];
        nser[heights.length - 1] = heights.length;

        Stack<Integer> st = new Stack<>();
        st.push(heights.length - 1);
        
        for(int i = heights.length - 2; i >= 0; i--){
            
            while(st.size() > 0 && heights[i] <= heights[st.peek()]){
                st.pop();
            }
            
            if(st.size() > 0)
                nser[i] = st.peek();
            else
                nser[i] = heights.length;
            
            st.push(i);
        }
        return nser;
    }
    
    
    public static int[] nself(int[] arr){
        int[] nsel = new int[arr.length];
        nsel[0] = -1;
        Stack<Integer> st = new Stack<>();
        st.push(0);
        
        for(int i = 1; i < arr.length; i++){
            while(st.size() > 0 && arr[i] <= arr[st.peek()]){
                st.pop();
            }
            if(st.size() == 0)
                nsel[i] = -1;
            else
                nsel[i] = st.peek();
            st.push(i);
        }
        
        return nsel;
    }
}