class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoder = new StringBuilder();
        for (String s: strs) {
            encoder.append(s.length())
            .append("#")
            .append(s);
        }
        return encoder.toString();
    }

    public List<String> decode(String str) {
        int i = 0;
        int l = 0;
        List<String> res = new ArrayList<>();
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') j++;
            l = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + l;
            res.add(str.substring(i , j));
            i = j;
        }
        return res;
    }
}
