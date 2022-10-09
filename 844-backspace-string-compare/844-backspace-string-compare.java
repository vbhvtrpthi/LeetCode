class Solution {
    public boolean backspaceCompare(String s, String t) {
       Stack<Character> st1 = stackHelper(s);
       Stack<Character> st2 = stackHelper(t);
       
        if(st1.size() != st2.size())
            return false;
        
        while(st1.size() > 0){
            if(st1.pop() != st2.pop())
                 return false;
        }
        
        return true;
    }
    
    public static Stack<Character> stackHelper(String s){
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != '#')
                st.push(s.charAt(i));
            else{
                if(st.size() > 0)
                    st.pop();
            }
                 
        }
        
        return st;
    }
}