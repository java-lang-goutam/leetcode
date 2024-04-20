class Solution {

    public int[][] findFarmland(int[][] land) {
        final int rows = land.length;
        final int cols = land[0].length;
        final List<int[]> result = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (land[i][j] == 1) {
                    int r1 = i, c1 = j, r2 = i, c2 = j;
                    for (int r = i; r < rows && land[r][j] == 1; r++) {
                        for (int c = j; c < cols && land[r][c] == 1; c++) {
                            r2 = r;
                            c2 = c;
                            land[r][c] = 0;
                        }
                    }

                    result.add(new int[] { r1, c1, r2, c2 });
                    //System.out.println(Arrays.deepToString(land));
                }
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
