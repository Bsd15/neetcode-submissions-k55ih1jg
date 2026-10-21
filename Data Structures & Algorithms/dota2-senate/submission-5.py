class Solution:
    def predictPartyVictory(self, senate: str) -> str:
        queue = deque()
        num_R = num_D = c_R = c_D = 0
        for s in senate:
            if s == "R":
                if c_R > 0:
                    c_R -= 1
                else:
                    num_R += 1
                    c_D += 1
                    queue.append("R")

            else:
                if c_D > 0:
                    c_D -= 1
                else:
                    num_D += 1
                    c_R += 1
                    queue.append("D")

        # print(queue, c_R, c_D)
        while (num_R > 0) and (num_D > 0):
            # print(queue, num_R, num_D, c_R, c_D)
            s = queue.popleft()
            # print(s)
            if s == "R":
                if c_R > 0:
                    c_R -= 1
                    num_R -= 1
                else:
                    c_D += 1
                    queue.append("R")
            else:
                if c_D > 0:
                    c_D -= 1
                    num_D -= 1
                else:
                    c_R += 1
                    queue.append("D")

        # print(num_R, num_D, queue)
        return "Radiant" if num_R > 0 else "Dire"
