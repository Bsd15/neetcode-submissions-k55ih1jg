class Solution:
    def canReach(self, s: str, minJump: int, maxJump: int) -> bool:
        n = len(s)
        dest = n - 1
        if s[dest] == 1:
            return False
        dp = [False] * n
        dp[0] = True
        count = 0
        for i in range(1, n):
            left = i - minJump
            if left >= 0 and dp[left]:
                count += 1
            right = i - maxJump - 1
            if right >= 0 and dp[right]:
                count -= 1
            if s[i] == '0' and count > 0:
                dp[i] = True
        return dp[dest]