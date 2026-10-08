class Solution:
    def canReach(self, s: str, minJump: int, maxJump: int) -> bool:
        n = len(s)
        destination = n - 1
        if s[destination] == '1':
            return False
        reachable = [False] * n
        reachable[destination] = True
        # if s[destination] == '0':
        #     reachable[destination] = True
        for i in range(destination - 1, -1, -1):
            if s[i] == '1':
                continue
            l = i + minJump
            if l > destination:
                continue
            r = min(i + maxJump, destination)
            for j in range(l, r + 1):
                if reachable[j]:
                    reachable[i] = True
                    break
        return reachable[0]