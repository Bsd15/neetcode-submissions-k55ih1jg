class Solution:
    def checkValidString(self, s: str) -> bool:
        if len(s) == 1:
            return False
        left_paran = []
        stars = []
        for i, c in enumerate(s):
            if c == '(':
                left_paran.append(i)
            elif c == '*':
                stars.append(i)
            else:
                if left_paran:
                    left_paran.pop()
                elif stars:
                    stars.pop()
                else:
                    return False
        while left_paran and stars:
            if left_paran[-1] < stars[-1]:
                left_paran.pop()
                stars.pop()
            else:
                break
        return len(left_paran) == 0