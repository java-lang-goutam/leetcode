class Solution {
    public int nthUglyNumber(int n) {
        
        final TreeSet<Long> set = new TreeSet<>();
        set.add(1L);
        long num = 0;

        while (n != 0) {
            n--;
            num = set.pollFirst();
            set.add(2 * num);
            set.add(3 * num);
            set.add(5 * num);
        }

        return (int) num;
    }
}