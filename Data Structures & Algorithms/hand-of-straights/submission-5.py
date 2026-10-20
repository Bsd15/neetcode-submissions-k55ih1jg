from collections import OrderedDict
class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        if len(hand)%groupSize != 0:
            return False
        freq = Counter(hand)
        for start in sorted(freq):
            count = freq[start]
            if count == 0:
                continue
            for i in range(start, start + groupSize):
                freq[i] = freq.get(i, 0) - count
                if freq[i] < 0:
                    return False
        return True