class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();
        for (String s: strs) {
            String sortedStr = Stream.of(s.split(""))
            .sorted()
            .collect(Collectors.joining());
            if (anagramGroups.containsKey(sortedStr)) {
                anagramGroups.get(sortedStr).add(s);
            }
            else {
                List<String> values = new  ArrayList<>();
                values.add(s);
                anagramGroups.put(sortedStr, values);
            }
        }
        return anagramGroups.values().stream().collect(Collectors.toList());
    }
}
