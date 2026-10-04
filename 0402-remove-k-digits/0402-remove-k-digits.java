class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if (k >= n) {
            return "0";
        }

        char[] stack = new char[n];
        int top = 0;

        for (int i = 0; i < n; i++) {
            char digit = num.charAt(i);
            while (top > 0 && k > 0 && stack[top - 1] > digit) {
                top--;
                k--;
            }
            stack[top++] = digit;
        }

        top -= k;

        int start = 0;
        while (start < top && stack[start] == '0') {
            start++;
        }

        if (start == top) {
            return "0";
        }

        return new String(stack, start, top - start);
    }
}