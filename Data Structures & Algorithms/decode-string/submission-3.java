class Solution {
    private int i = 0;
    public String decodeString(String s) {
        this.i = 0;
        return decode(s);
    }

    private String decode(String s) {
        int num = 0;
        StringBuilder sb = new StringBuilder();
        while (this.i < s.length()) {
            char c = s.charAt(this.i++);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                sb.repeat(decode(s), num);
                num = 0;
            } else if (c == ']') {
                return  sb.toString();
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}