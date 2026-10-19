class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0 || s.length() == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;
        int sLen = s.length();

        if (sLen < totalLen) {
            return result;
        }

        Map<String, Integer> wordFreq = new HashMap<>();
        for (String w : words) {
            wordFreq.put(w, wordFreq.getOrDefault(w, 0) + 1);
        }

        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int right = i;
            int matched = 0;
            Map<String, Integer> currentFreq = new HashMap<>();

            while (right + wordLen <= sLen) {
                String sub = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordFreq.containsKey(sub)) {
                    currentFreq.put(sub, currentFreq.getOrDefault(sub, 0) + 1);
                    matched++;

                    while (currentFreq.get(sub) > wordFreq.get(sub)) {
                        String leftWord = s.substring(left, left + wordLen);
                        currentFreq.put(leftWord, currentFreq.get(leftWord) - 1);
                        matched--;
                        left += wordLen;
                    }

                    if (matched == wordCount) {
                        result.add(left);
                    }
                } else {
                    currentFreq.clear();
                    matched = 0;
                    left = right;
                }
            }
        }

        return result;
    }
}