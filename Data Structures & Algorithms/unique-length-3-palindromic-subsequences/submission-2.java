class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] firstSeenIdx = new int[26];
        int[] lastSeenIdx = new int[26];

        Arrays.fill(firstSeenIdx, -1);
        Arrays.fill(lastSeenIdx, -1);

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (firstSeenIdx[index] == -1) {
                firstSeenIdx[index] = i;
            }
            lastSeenIdx[index] = i;
        }

        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (firstSeenIdx[i] != -1 && lastSeenIdx[i] - firstSeenIdx[i] > 1) {
                Set<Character> uniqueChars = new HashSet<>();
                for (int j = firstSeenIdx[i] + 1; j < lastSeenIdx[i]; j++) {
                    uniqueChars.add(s.charAt(j));
                }
                count += uniqueChars.size();
            }
        }

        return count;
    }
}