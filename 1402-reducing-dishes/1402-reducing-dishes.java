class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);

        int maxTotal = 0;
        int runningSum = 0;

        for (int i = satisfaction.length - 1; i >= 0; i--) {
            if (runningSum + satisfaction[i] > 0) {
                runningSum += satisfaction[i];
                maxTotal += runningSum;
            } else {
                break;
            }
        }

        return maxTotal;
    }
}