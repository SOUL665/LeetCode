class Solution {
    public boolean rotateString(String s, String goal) {
        int q = s.length();
        int w = goal.length();

        if(q != w){
            return false;
        }

        String a = s + s;
        return a.contains(goal);
    }
}