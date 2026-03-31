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


        StringBuilder res = new StringBuilder("/");
        for (String d : stack) {
            res.append(d)
                    .append("/");
        }
        if (res.length() > 1) {
            res.deleteCharAt(res.length() - 1);
        }
        return res.toString();
    }
}