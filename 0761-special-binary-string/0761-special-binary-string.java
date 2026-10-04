class Solution {
    public String makeLargestSpecial(String s) {
        List<String> list = new ArrayList<>();
        int count = 0;
        int i = 0;

        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '1') {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                list.add("1" + makeLargestSpecial(s.substring(i + 1, j)) + "0");
                i = j + 1;
            }
        }

        list.sort(Collections.reverseOrder());

        return String.join("", list);
    }
}