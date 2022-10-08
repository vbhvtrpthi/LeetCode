class Solution {
    public int[] dailyTemperatures(int[] temp) {
      int[] nger = new int[temp.length];
      Stack<Integer> st = new Stack<>();
      st.push(0);
      for(int i = 1; i < temp.length; i++){
          while(st.size() > 0 && temp[st.peek()] < temp[i]){
              nger[st.peek()] = i - st.pop();
          }
          
          st.push(i);
      }
    
    while(st.size() > 0){
        nger[st.pop()] = 0;
    }
        
     return nger;
    }
}