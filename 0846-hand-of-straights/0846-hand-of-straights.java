class Solution {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        if (groupSize == 1) return true;

        final Map<Integer, Integer> map = new TreeMap<>();
        for (final int h : hand) {
            map.compute(h, (k, v) -> v == null ? 1 : 1 + v);
        }

        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            final Map.Entry<Integer, Integer> entry = it.next();
            Integer key = entry.getKey();
            final Integer count = entry.getValue();
            //System.out.println("Checking key : " + key + ", count : " + count);
            it.remove();

            if (count == 0) {
                it = map.entrySet().iterator();
                continue;
            }

            final Map<Integer, Integer> updates = new HashMap<>();

            for (int i = 1; i < groupSize; i++) {
                if (!it.hasNext()) {
                    //System.out.println("No new elements");
                    return false;
                }
                final Map.Entry<Integer, Integer> nextEntry = it.next();
                final Integer nextKey = nextEntry.getKey();
                final Integer nextCount = nextEntry.getValue();

                //System.out.println("Checking nextKey : " + nextKey + ", nextCount : " + nextCount);

                if (nextKey != key + 1) {
                    //System.out.println("Next key is not one more");
                    return false;
                }
                if (nextCount < count) {
                    //System.out.println("Fewer elements than required");
                    return false;
                }
                updates.put(nextKey, nextCount - count);
                key = nextKey;
            }

            for (Integer uk : updates.keySet()) {
                map.put(uk, updates.get(uk));
            }
            //System.out.println(map);
            it = map.entrySet().iterator();
        }

        return true;
    }
}
