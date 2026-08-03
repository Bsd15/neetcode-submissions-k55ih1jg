class Solution {
    private final static char seperator = '#';

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append(seperator).append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        int currStrLen = 0;
        while (i < str.length()) {
            while (str.charAt(i) != seperator) {
                char c = str.charAt(i);
                currStrLen = 10 * currStrLen + (c - '0');
                i++;
            }

            i++;
            result.add(str.substring(i, i + currStrLen));
            i += currStrLen;
            currStrLen = 0;
        }
        return result;
    }
}
