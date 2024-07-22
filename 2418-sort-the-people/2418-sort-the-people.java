class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        final Map<Integer, String> map = new HashMap<>();
        for (int i=0, l = heights.length; i < l; i++) {
            map.put(heights[i], names[i]);
        }
        
        Arrays.sort(heights);
        
        for (int i=heights.length - 1, j = i; i >= 0; i--)
            names[j - i] = map.get(heights[i]);

        return names;
    }
}