class Solution {
    public boolean checkIfPangram(String sentence) {
        
        Set<Character> set = new HashSet<>();
        
        for(char c: sentence.toCharArray()){
            set.add(c);
        }
        
        if(set.size() == 26)
            return true;
        
        return false;
    }
}