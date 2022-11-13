class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        
        String rev = "";
        for(int i = arr.length - 1; i >= 0; i--){
            if(!arr[i].equals(""))
                 rev = rev + arr[i] + " ";
        }
        
        rev = rev.substring(0, rev.length() - 1);
        return rev;
        
        
    }
}