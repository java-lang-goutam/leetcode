class Solution {

    public List<String> commonChars(String[] words) {
        final int[] freq = new int[26];
        final String firstWord = words[0];
        for (int i = 0, n = firstWord.length(); i < n; i++) {
            freq[firstWord.charAt(i) - 'a']++;
        }

        final int[] currFreq = new int[26];
        for (int i = 1; i < words.length; i++) {
            final String word = words[i];
            for (int c = 0, n = word.length(); c < n; c++) {
                currFreq[word.charAt(c) - 'a']++;
            }
            for (int c = 0; c < 26; c++) {
                freq[c] = Math.min(currFreq[c], freq[c]);
                currFreq[c] = 0;
            }
        }

        final List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < freq[i]; j++) {
                result.add(String.valueOf((char) (i + 'a')));
            }
        }

        return result;
    }
}
