class Solution {
    public int countPalindromicSubsequence(String s) {
        if (s.length() < 3) {
            return 0;
        }

        int[] firstSeenIdx = new int[26];
        int[] lastSeenIdx = new int[26];
        Arrays.fill(firstSeenIdx, -1);
        Arrays.fill(lastSeenIdx, -1);
        
        for (int i = 0; i < s.length(); i++) {
            int charIdx = s.charAt(i) - 'a';
            if (firstSeenIdx[charIdx] == -1) {
                firstSeenIdx[charIdx] = i;
            }
            lastSeenIdx[charIdx] = i;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (firstSeenIdx[i] != -1 && lastSeenIdx[i] > firstSeenIdx[i] + 1) {
                Set<Character> middleChars = new HashSet<>();
                for (int j = firstSeenIdx[i] + 1; j < lastSeenIdx[i]; j++) {
                    middleChars.add(s.charAt(j));
                }
                count += middleChars.size();
            }
        }

        return count;
    }
}