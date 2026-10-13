class Solution {
    public int maxRepeating(String sequence, String word) {
        String copy = word;
        int ans = 0; 

        while(sequence.contains(copy)){
            copy += word;
            ans++;
        }
        return ans;
    }
}