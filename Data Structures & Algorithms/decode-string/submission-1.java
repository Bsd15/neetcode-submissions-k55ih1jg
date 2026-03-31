class Solution {
    public String decodeString(String s) {
        int repeatCount = 0;
        StringBuilder str = new StringBuilder();
        boolean push = false;
        Deque<Map.Entry<Integer, StringBuilder>> stack = new ArrayDeque<>(s.length());
        stack.addLast(Map.entry(1, new StringBuilder()));
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ']') {
                if (push) {
                    stack.addLast(Map.entry(repeatCount, str));
                } else {
                    stack.getLast().getValue().append(str);
                }
                repeatCount = 0;
                push = false;
                str = new StringBuilder();
                var top = stack.removeLast();
                if (!stack.isEmpty()) {
                    stack.getLast().getValue().repeat(top.getValue(), top.getKey());
                } else {
                    stack.addLast(Map.entry(1, new StringBuilder().repeat(top.getValue(), top.getKey())));
                }
            } else if (Character.isDigit(c)) {
                if (push) {
                    stack.addLast(Map.entry(repeatCount, str));
                    repeatCount = 0;
                    str = new StringBuilder();
                    push = false;
                } else if (!push && repeatCount <= 1 && str.length() > 0) {
                    stack.getLast().getValue().append(str);
                    str = new StringBuilder();
                }
                repeatCount = repeatCount * 10 + ((int) c - '0');
            } else if (c == '[') {
                push = true;
            } else if (Character.isAlphabetic(c)) {
                str.append(c);
                if (i + 1 == s.length()) {
                    stack.getLast().getValue().append(str);
                }
            }
        }
        return stack.getLast().getValue().toString();

    }
}