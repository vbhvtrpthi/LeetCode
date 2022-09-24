class Solution {
    public int countHousePlacements(int n) {
        int m = (int)1e9 + 7;
        
        int sp = 1;
        int bd = 1;
        
        for(int i = 2; i <= n; i++){
            int nsp = (sp +  bd) % m;
            int nbd = sp;
            
            sp = nsp;
            bd = nbd;
        }
        
        int res = sp + bd;
        return (int)(1L * res * res % m);
    }
}