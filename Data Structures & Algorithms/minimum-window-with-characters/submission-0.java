class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";

        int[] tCharCount = new int[58];
        for (char c : t.toCharArray()) {
            ++tCharCount[c - 'A'];
        }

        int left = 0;
        int missMatchScore = t.length();
        int currentMissMatchScore = 0;
        int resultSize = Integer.MAX_VALUE;
        int[] result = new int[2];
        int[] sCharCount = new int[58];
        for (int right = 0; right < s.length(); right++) {
            int sRightChar = s.charAt(right) - 'A';
            ++sCharCount[sRightChar];
            if (tCharCount[sRightChar] > 0 && sCharCount[sRightChar] >= 1
                    && sCharCount[sRightChar] <= tCharCount[sRightChar]) {
                currentMissMatchScore++;
            }

            while (missMatchScore == currentMissMatchScore) {
                int sLeftChar = s.charAt(left) - 'A';
                if (resultSize > (right - left + 1)) {
                    result[0] = left;
                    result[1] = right;
                    resultSize = right - left + 1;
                }

                --sCharCount[sLeftChar];

                if (tCharCount[sLeftChar] > 0 && sCharCount[sLeftChar] < tCharCount[sLeftChar]) {
                    currentMissMatchScore--;
                }

                left++;
            }
        }

        return resultSize == Integer.MAX_VALUE ? "" : s.substring(result[0], result[1] + 1);
    }
}
