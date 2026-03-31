class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        var res = Arrays.stream(arr)
                .boxed()
                .sorted((a,b) -> {
                    int aDiff = Math.abs(a - x);
                    int bDiff = Math.abs(b - x);
                    if (aDiff < bDiff || (aDiff == bDiff && a < b)) {
                        return -1;
                    } else if (aDiff == bDiff && a.equals(b)) {
                        return 0;
                    } else {
                        return 1;
                    }
                })
                .limit(k)
                .sorted()
                .toList();

        return res;
    }
}