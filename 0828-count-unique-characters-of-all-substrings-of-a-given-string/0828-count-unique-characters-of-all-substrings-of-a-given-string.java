class Solution {
    public int uniqueLetterString(String s) {
        int n = s.length();
        int[] lastPos = new int[26];
        int[] prevPos = new int[26];

        Arrays.fill(lastPos, -1);
        Arrays.fill(prevPos, -1);

        int total = 0;

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'A';
            if (lastPos[c] != -1) {
                total += (lastPos[c] - prevPos[c]) * (i - lastPos[c]);
            }
            prevPos[c] = lastPos[c];
            lastPos[c] = i;
        }

        for (int c = 0; c < 26; c++) {
            if (lastPos[c] != -1) {
                total += (lastPos[c] - prevPos[c]) * (n - lastPos[c]);
            }
        }

        return total;
    }
}