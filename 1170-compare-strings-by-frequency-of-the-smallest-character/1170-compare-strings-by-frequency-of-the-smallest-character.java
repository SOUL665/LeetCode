class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] freqCount = new int[12];

        for (String word : words) {
            freqCount[f(word)]++;
        }

        int[] suffixSum = new int[12];
        for (int i = 10; i >= 1; i--) {
            suffixSum[i] = suffixSum[i + 1] + freqCount[i];
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int qFreq = f(queries[i]);
            answer[i] = suffixSum[qFreq + 1];
        }

        return answer;
    }

    private int f(String s) {
        char minChar = 'z';
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < minChar) {
                minChar = c;
                count = 1;
            } else if (c == minChar) {
                count++;
            }
        }

        return count;
    }
}