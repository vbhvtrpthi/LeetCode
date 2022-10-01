class Solution {
     static String[] codes ={"abc" , "def" , "ghi" , "jkl" ,"mno" ,"pqrs" , "tuv" ,"wxyz" };
    public List<String> letterCombinations(String digits) {
               
        if(digits.length()==0)
            return new ArrayList<>();
        
           return getKpc(digits);
    }
    
     public List<String> getKpc(String digits) {
        
        if(digits.length() == 0){
            List<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        char ch = digits.charAt(0); // 1
         
        String remDig = digits.substring(1); // 2
        
        List<String> rres = getKpc(remDig); // 3
        
        List<String> mres = new ArrayList<>(); // 4
        
        String codeStr = codes[ch - '0' -2]; // 5
        
        for(int i = 0 ; i<codeStr.length() ; i++ ) // 6
        {
            char codeAtcodeStr = codeStr.charAt(i);
            
            for(String rstr : rres)
                mres.add(codeAtcodeStr + rstr);
        }
        
        return mres; // 7
    }
}