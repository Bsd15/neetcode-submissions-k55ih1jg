from collections import OrderedDict
class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        if len(hand)%groupSize != 0:
            return False
        freq = Counter(hand)
        for start in sorted(freq):
            while freq[start] > 0:
                for i in range(start, start + groupSize):
                    if not freq[i]:
                        return False
                    freq[i] -= 1
        return True