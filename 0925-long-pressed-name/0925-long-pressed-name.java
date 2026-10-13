class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int n1 = name.length();
        int n2 = typed.length();
        int a = 0, b = 0;

        while (a < n1 && b < n2) {
            if (name.charAt(a) == typed.charAt(b)) {
                a++;
                b++;
            } 
            else if (a > 0 && name.charAt(a - 1) == typed.charAt(b)) {
                b++;
            } 
            else {
                return false;
            }
        }
        if (a < n1) {
            return false;
        }
        while (b < n2) {
            if (name.charAt(a - 1) != typed.charAt(b)) {
                return false;
            }
            b++;
        }
        return true;
    }
}