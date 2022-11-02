class Solution {

    public int averageValue(int[] nums) {
        int sum = 0;
        int cnt = 0;

        for (int val : nums) {
            if (val % 2 == 0 && val % 3 == 0) {
                sum += val;
                cnt++;
            }
        }
        if(sum == 0) return 0;

        return sum / cnt;
    }
}
