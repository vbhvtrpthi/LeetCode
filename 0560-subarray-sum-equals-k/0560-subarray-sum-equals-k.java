class Solution {

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        int cnt = 0;
        int ps = 0;

        for (int val : nums) {
            ps += val;

            if (map.containsKey(ps - k)) {
                cnt += map.get(ps - k);
            }

            if (map.containsKey(ps)) {
                map.put(ps, map.get(ps) + 1);
            } else {
                map.put(ps, 1);
            }
        }

        return cnt;
    }
}
