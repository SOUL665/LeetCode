class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] sCount = new int[26];
        int[] targetCount = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < target.length(); i++) {
            targetCount[target.charAt(i) - 'a']++;
        }

        int maxCopies = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (targetCount[i] > 0) {
                maxCopies = Math.min(maxCopies, sCount[i] / targetCount[i]);
            }
        }

        return maxCopies;
    }
}