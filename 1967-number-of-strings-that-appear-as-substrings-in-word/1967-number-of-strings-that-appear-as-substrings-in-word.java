class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int q = patterns.length;
        int w = word.length();
        int ans = 0;

        for(int i = 0; i < q;i++){
            if(word.contains(patterns[i])){
                ans++;
            }
        }
        return ans;
    }
}