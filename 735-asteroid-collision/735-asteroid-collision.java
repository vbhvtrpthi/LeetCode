class Solution {
    public int[] asteroidCollision(int[] arr) {
         
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < arr.length; i++){
            if(st.size() == 0){
                st.push(arr[i]);
            }else if(arr[i] > 0){
                st.push(arr[i]);
            }else if(st.peek() < 0){
                st.push(arr[i]);
            }else{
                while(st.size() > 0 && st.peek() > 0 && st.peek() < Math.abs(arr[i])){
                    st.pop();
                }
                if(st.size() == 0){
                    st.push(arr[i]);
                }else if(st.peek() < 0){
                    st.push(arr[i]);
                }else if(st.peek() == Math.abs(arr[i])){
                    st.pop();
                }
            }
            
        }
        
        int[] res = new int[st.size()];
        int i = st.size() - 1;
        while(st.size() > 0){
            res[i] = st.pop();
            i--;
        }
        
        return res;
    }
}