/**

https://www.youtube.com/watch?v=Fv3M9uO5ovU

*/

class Solution {
    public int minKBitFlips(int[] nums, int k) {
     
        
        final Deque<Integer> flipIndices = new LinkedList<>();
        int result = 0;
        
        for (int i=0, n = nums.length; i < n; i++) {
            
            // remove invalid indices
            while (flipIndices.size() > 0 && i > flipIndices.getFirst() + k-1) {
                flipIndices.removeFirst();
            }
            
            
            // flip condition
            if ((nums[i] + flipIndices.size()) % 2 == 0) {
                
                // if cant flip k times 
                if (i + k > n) return -1;
                result++;
                flipIndices.add(i);
            }
            
        }
        
        return result;
        
    }
}