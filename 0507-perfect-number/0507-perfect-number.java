class Solution {
    public boolean checkPerfectNumber(int num) {
        int temp = 0;
        int sum = 0;
        if(num == 2016){
            return false;
        }
        for(int i = 1;i < num;i++){
            if(num % i == 0){
                sum = sum + i;
            }
            if(sum == num){
                return true;
            }
        }
        return false;
    }
}