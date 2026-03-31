class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        final int R = 256;
        int[] r = new int[R];
        for (char i : s.toCharArray()) {
            ++r[i];
        }

        int[] r2 = new int[R];
        for (char i : t.toCharArray()) {
            ++r2[i];
        }

        for (int i = 0; i < R; i++) {
            if (r[i] != r2[i]) return false;
        }

        return true;
    }
}
