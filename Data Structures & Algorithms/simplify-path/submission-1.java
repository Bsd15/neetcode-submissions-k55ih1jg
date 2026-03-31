class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        StringBuilder dir = new StringBuilder();
        path += '/';
        for (char c : path.toCharArray()) {
            if (c != '/') {
                dir.append(c);
            } else {
                String currDir = dir.toString();
                if (currDir.equals("..")) {
                    stack.pollLast();
                } else if (currDir.equals(".")) {
//                    Do nothing
                } else if (!currDir.isBlank()){
                    stack.add(currDir);
                }
                dir.setLength(0);
            }
        }
        return "/" + String.join("/", stack);
    }
}