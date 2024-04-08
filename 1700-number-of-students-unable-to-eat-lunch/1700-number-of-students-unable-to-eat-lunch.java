class Solution {

    public int countStudents(int[] students, int[] sandwiches) {
        int j = 0, n = students.length, circularLeft = 0, squareLeft = 0;
        for (int i = 0; i < n; i++) {
            if (students[i] == sandwiches[j]) j++; 
            else if (students[i] == 0) circularLeft++; 
            else squareLeft++;
        }

        // System.out.println("circularLeft =" + circularLeft);
        // System.out.println("squareLeft =" + squareLeft);
        // System.out.println("j =" + j);

        while (j < n) {
            if (sandwiches[j] == 0 && --circularLeft < 0) break; 
            else if (sandwiches[j] == 1 && --squareLeft < 0) break;
            j++;
        }

        return n - j;
    }
}
