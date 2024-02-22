class Solution {
    
    class Node {
        int incomingCount, outgoingCount;
    }
    
    public int findJudge(int n, int[][] trust) {
        
        final Node[] people = new Node[n+1];
        for (int i=1; i<=n; i++) {
            people[i] = new Node();
        }
        
        for (int[] pairs : trust) {
            final int from = pairs[0];
            final int to = pairs[1];
            people[from].outgoingCount++;
            people[to].incomingCount++;
        }

        for (int i=1; i<=n; i++) {
            if (people[i].outgoingCount == 0 && people[i].incomingCount == n-1) {
                return i;
            }
        }
        
        return -1;
    }
}