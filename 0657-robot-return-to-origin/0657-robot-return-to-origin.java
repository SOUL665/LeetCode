class Solution {
    public boolean judgeCircle(String moves) {
        int n = moves.length();
        int ans = 0;

        
        for(int i = 0; i < n; i++){
            if(moves.charAt(i) == 'U'){
                ans = ans + 1;
            }
            else if(moves.charAt(i) == 'D'){
                ans = ans - 1;
            }
            else if(moves.charAt(i) == 'R'){
                ans = ans + 3;
            }
            else if(moves.charAt(i) == 'L'){
                ans = ans - 3;
            }
        }

        if(ans == 0){
            return true;
        }
        return false; 
    }
}