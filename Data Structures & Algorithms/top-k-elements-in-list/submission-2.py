class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq_count = defaultdict(int)
        max_count = 0
        for n in nums:
            freq_count[n] += 1
            max_count = max(freq_count[n], max_count)
        num_counts = []
        for i in range(max_count + 1):
            num_counts.append([])
        for n, c in freq_count.items():
            num_counts[c].append(n)
        res = []
        i = len(num_counts) - 1
        while k > 0:
            for j in num_counts[i]:
                res.append(j)
                k -= 1
                if k == 0:
                    break
            i -= 1
        return res