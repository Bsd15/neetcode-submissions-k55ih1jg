class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        for c in tokens:
            if c not in {'+', '-', '*', '/'}:
                stack.append(int(c))
            else:
                num1 = stack.pop()
                num2 = stack.pop()

                if c == '+':
                    stack.append(num2 + num1)
                elif c == '-':
                    stack.append(num2 - num1)
                elif c == '*':
                    stack.append(num2 * num1)
                elif c =='/':
                    stack.append(int(num2 / num1))
        return stack.pop()