class Solution:
    def canReach(self, s: str, minJump: int, maxJump: int) -> bool:
        if s[-1] == '1':
            return False
        reachable = [False] * len(s)
        reachable[0] = True
        count = 0
        for i in range(len(s)):
            left = i - maxJump - 1
            right = i - minJump
            if left >= 0 and reachable[left]:
                count -= 1
            if right >= 0 and reachable[right]:
                count += 1
            if count > 0 and s[i] == '0':
                reachable[i] = True
        return reachable[-1]