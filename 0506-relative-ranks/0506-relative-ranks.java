class Solution {

    public int[] getHashTable(final int[] score) {
        int max = -1;
        for (int sc : score) {
            if (max < sc) max = sc;
        }
        
        return new int[max + 1];
    }
    
    public String[] findRelativeRanks(int[] score) {
        
        final int[] hashTable = getHashTable(score);
        final int n = score.length;
        
        for (int i = 0; i < n; i++) {
            hashTable[score[i]] = i;
        }

        Arrays.sort(score);

        final String[] result = new String[n];

        if (n >= 1) result[hashTable[score[n - 1]]] = "Gold Medal";
        if (n >= 2) result[hashTable[score[n - 2]]] = "Silver Medal";
        if (n >= 3) result[hashTable[score[n - 3]]] = "Bronze Medal";

        int pos = 4;
        for (int i = n - 4; i >= 0; i--) {
            result[hashTable[score[i]]] = pos++ + "";
        }

        return result;
    }
}
