class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        n = len(s)
        if n == 1:
            return [1]
        end_pos = [0] * 26
        for i, c in enumerate(s):
            end_pos[ord(c) - ord('a')] = i
        result = []
        curr_grp = [0, end_pos[ord(s[0]) - ord('a')]]
        for i, c in enumerate(s):
            if curr_grp[1] == n - 1:
                break
            currCharEnd = end_pos[ord(c) - ord('a')]
            if curr_grp[0] <= i <= curr_grp[1]:
                curr_grp[1] = max(curr_grp[1], currCharEnd)
            else:
                result.append(curr_grp[1] - curr_grp[0] + 1)
                curr_grp = [i, currCharEnd]

        result.append(curr_grp[1] - curr_grp[0] + 1)
        
        return result
