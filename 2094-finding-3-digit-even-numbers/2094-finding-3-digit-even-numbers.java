class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] counts = new int[10];
        for (int d : digits) {
            counts[d]++;
        }
        
        List<Integer> resultList = new ArrayList<>();
        
        for (int i = 1; i <= 9; i++) {
            if (counts[i] == 0) continue;
            counts[i]--;
            
            for (int j = 0; j <= 9; j++) {
                if (counts[j] == 0) continue;
                counts[j]--;
                
                for (int k = 0; k <= 8; k += 2) {
                    if (counts[k] == 0) continue;
                    
                    resultList.add(i * 100 + j * 10 + k);
                }
                
                counts[j]++;
            }
            
            counts[i]++;
        }
        
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        
        return result;
    }
}