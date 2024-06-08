class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        final Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int sum = 0, i = 0;
        for (int num : nums) {
            sum += num;
            final int rem = sum % k;
            if (map.containsKey(rem)) {
                final int prevIndex = map.get(rem);
                // System.out.println("prevIndex " + prevIndex);
                // System.out.println("currIndex " + i);
                if (i - prevIndex > 1) return true;
            } else {
                map.put(rem, i);
            }
            i++;
            // System.out.println(map);
        }
        
        return false;
    }
}