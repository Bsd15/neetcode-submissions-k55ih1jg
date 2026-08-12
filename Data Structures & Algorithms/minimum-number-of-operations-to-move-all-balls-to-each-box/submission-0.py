class Solution:
    def minOperations(self, boxes: str) -> List[int]:
        prefix_hops = [0] * len(boxes)
        suffix_hops = [0] * len(boxes)

        curr_ones = int(boxes[0])
        for i in range(1, len(boxes)):
            prefix_hops[i] = curr_ones + prefix_hops[i - 1]
            curr_ones += int(boxes[i])
        
        curr_ones = int(boxes[-1])
        for i in range(len(boxes) - 2, -1, -1):
            suffix_hops[i] = suffix_hops[i + 1] + curr_ones
            curr_ones += int(boxes[i])
        
        res = [0] * len(boxes)
        for i in range(len(boxes)):
            res[i] = prefix_hops[i] + suffix_hops[i]
        
        return res