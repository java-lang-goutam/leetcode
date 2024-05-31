/**

Finally understand it.

Let a and b be the two unique numbers
XORing all numbers gets you (a xor b)
(a xor b) must be non-zero otherwise they are equal
If bit_i in (a xor b) is 1, bit_i at a and b are different.
Find bit_i using the low bit formula m & -m
Partition the numbers into two groups: one group with bit_i == 1 and the other group with bit_i == 0.
a is in one group and b is in the other.
a is the only single number in its group.
b is also the only single number in its group.
XORing all numbers in a's group to get a
XORing all numbers in b's group to get b
Alternatively, XOR (a xor b) with a gets you b.

*/

public class Solution {
    public int[] singleNumber(int[] nums) {
        // Pass 1 : 
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // Get its last set bit
        diff &= -diff;
        
        // Pass 2 :
        int[] rets = {0, 0}; // this array stores the two numbers we will return
        for (int num : nums)
        {
            if ((num & diff) == 0) // the bit is not set
            {
                rets[0] ^= num;
            }
            else // the bit is set
            {
                rets[1] ^= num;
            }
        }
        return rets;
    }
}