class Solution {
    private final static String vowels = "AEIOUaeiou";
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] numOfWords = new int[words.length + 1];
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            int countWord = 0;
            if (
                isVowel(s.charAt(0)) 
                && isVowel(s.charAt(s.length() - 1))
            ) {
                countWord = 1;
            }
            numOfWords[i + 1] = numOfWords[i] + countWord;
        }

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            result[i] = numOfWords[query[1] + 1] - numOfWords[query[0]];
        }

        return result;
    }

    private static boolean isVowel(char c) {
        return vowels.indexOf(c) != -1;
    }
}