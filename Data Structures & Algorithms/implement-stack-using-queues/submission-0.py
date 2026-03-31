class MyStack:

    def __init__(self):
        self.q = []
        self.top_ele = 0
        self.size = 0

    def push(self, x: int) -> None:
        self.q.append(x)
        self.top_ele = x
        self.size += 1

    def pop(self) -> int:
        for i in range(self.size - 1):
            self.top_ele = self.q[0]
            self.q.append(self.q.pop(0))
        self.size -= 1
        return self.q.pop(0)
        

    def top(self) -> int:
        return self.top_ele

    def empty(self) -> bool:
        return self.size == 0

        


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()