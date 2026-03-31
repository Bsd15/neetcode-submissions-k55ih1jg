class Solution {
    public static String decodeString(String s) {
        int num = 0;
        StringBuilder curr = new StringBuilder();
        Deque<Map.Entry<Integer, StringBuilder>> stack = new ArrayDeque<>();
        for (char c: s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                stack.push(Map.entry(num, curr));
                curr = new StringBuilder();
                num = 0;
            } else if (c == ']') {
                var top = stack.pop();
                StringBuilder prev = top.getValue();
                int repeat = top.getKey();
                prev.repeat(curr, repeat);
                curr = prev;
            } else {
                curr.append(c);
            }
        }
        return curr.toString();
    }
}