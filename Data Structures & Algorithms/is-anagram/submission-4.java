class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        final int R = 256;
        int[] r = new int[R];
        for (char i : s.toCharArray()) {
            ++r[i];
        }

        for (char i : t.toCharArray()) {
            --r[i];
        }

        for (int i: r) {
            if (i != 0) return false;
        }

        return true;
    }
}
