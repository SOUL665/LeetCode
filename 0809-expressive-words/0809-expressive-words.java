class Solution {
    public int expressiveWords(String s, String[] words) {
        int count = 0;
        for (String word : words) {
            if (isStretchy(s, word)) {
                count++;
            }
        }
        return count;
    }

    private boolean isStretchy(String s, String word) {
        int i = 0;
        int j = 0;
        int n = s.length();
        int m = word.length();

        while (i < n && j < m) {
            if (s.charAt(i) != word.charAt(j)) {
                return false;
            }

            int sEnd = i;
            while (sEnd < n && s.charAt(sEnd) == s.charAt(i)) {
                sEnd++;
            }
            int lenS = sEnd - i;

            int wEnd = j;
            while (wEnd < m && word.charAt(wEnd) == word.charAt(j)) {
                wEnd++;
            }
            int lenW = wEnd - j;

            if (lenS < lenW || (lenS > lenW && lenS < 3)) {
                return false;
            }

            i = sEnd;
            j = wEnd;
        }

        return i == n && j == m;
    }
}