class Solution {

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        final int totalMinutes = customers.length;
        int windowValue = 0, maxWindowValue = 0, maxSatisfiedCustomers = 0;

        for (int i = 0, j = 0; i < totalMinutes; i++) {
            if (grumpy[i] == 1) windowValue += customers[i]; 
            else maxSatisfiedCustomers += customers[i];

            if (i >= minutes) {
                if (grumpy[j] == 1) windowValue -= customers[j];
                j++;
            }

            //System.out.println("windowValue : " + windowValue);
            maxWindowValue = Math.max(maxWindowValue, windowValue);
        }

        // System.out.println("maxWindowValue : " + maxWindowValue);
        // System.out.println("maxSatisfiedCustomers : " + maxSatisfiedCustomers);

        return maxWindowValue + maxSatisfiedCustomers;
    }
}
