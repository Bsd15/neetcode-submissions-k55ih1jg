class Solution {
    public boolean isPalindrome(String s) {
        if (s.isBlank()) return true;
        s = s.toLowerCase();
        int l = s.length() - 1;
        for (int left = 0, right = l; left < right; left++, right--) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
                left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
                right--;
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
        }
        return true;
    }
}
