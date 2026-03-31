class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for c in s:
            if c == '(' or c == '[' or c == '{':
                stack.append(c)
            else:
                if not stack:
                    return False
                left_paran = stack.pop()
                if c == ')' and left_paran != '(':
                    return False 
                elif c == ']' and left_paran != '[':
                    return False 
                elif c == '}' and left_paran != '{':
                    return False
        return False if stack else True