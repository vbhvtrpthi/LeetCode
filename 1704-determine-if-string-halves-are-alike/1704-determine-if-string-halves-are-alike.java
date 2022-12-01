class Solution {
    public boolean halvesAreAlike(String s) {
        var vow = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int c1 = 0;
        int c2 = 0;
        for(int i = 0, j = s.length() - 1; i < s.length() / 2 ; i++, j--){
            c1 += vow.contains(s.charAt(i)) ? 1 : 0;
            c2 += vow.contains(s.charAt(j)) ? 1 : 0;
        }
        
        if(c1 == c2) return true;
        return false;
    }
}