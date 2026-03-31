class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq_count = defaultdict(int)

        for n in nums:
            freq_count[n] += 1
        
        num_counts = [[] for i in range(len(nums) + 1)]
      
        for n, c in freq_count.items():
            num_counts[c].append(n)

        res = []
        for i in range(len(num_counts) - 1, 0, -1):
            if num_counts[i]:
                res = res + num_counts[i]
            if len(res) == k:
                return res