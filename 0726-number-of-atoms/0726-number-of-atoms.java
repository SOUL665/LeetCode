class Solution {
    public String countOfAtoms(String formula) {
        Deque<Map<String, Integer>> stack = new ArrayDeque<>();
        stack.push(new HashMap<>());

        int n = formula.length();
        int i = 0;

        while (i < n) {
            char c = formula.charAt(i);

            if (c == '(') {
                stack.push(new HashMap<>());
                i++;
            } else if (c == ')') {
                i++;
                int start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int multiplier = (start == i) ? 1 : Integer.parseInt(formula.substring(start, i));

                Map<String, Integer> top = stack.pop();
                Map<String, Integer> prev = stack.peek();

                for (Map.Entry<String, Integer> entry : top.entrySet()) {
                    prev.put(entry.getKey(), prev.getOrDefault(entry.getKey(), 0) + entry.getValue() * multiplier);
                }
            } else {
                int start = i++;
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String name = formula.substring(start, i);

                start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int count = (start == i) ? 1 : Integer.parseInt(formula.substring(start, i));

                Map<String, Integer> curr = stack.peek();
                curr.put(name, curr.getOrDefault(name, 0) + count);
            }
        }

        Map<String, Integer> counts = stack.pop();
        TreeMap<String, Integer> sortedCounts = new TreeMap<>(counts);

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : sortedCounts.entrySet()) {
            sb.append(entry.getKey());
            if (entry.getValue() > 1) {
                sb.append(entry.getValue());
            }
        }

        return sb.toString();
    }
}