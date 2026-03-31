class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();
        for (String s: strs) {
            String sortedStr = Stream.of(s.split(""))
            .sorted()
            .collect(Collectors.joining());
            anagramGroups.putIfAbsent(sortedStr, new ArrayList<>());
            anagramGroups.get(sortedStr).add(s);
        }
        return new ArrayList<>(anagramGroups.values());
    }
}
