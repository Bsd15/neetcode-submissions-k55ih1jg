class FreqStack:

    def __init__(self):
        self.freq = {}
        self.stacks = [[]]

    def push(self, val: int) -> None:
        count = self.freq.get(val, 0) + 1
        self.freq[val] = count
        currVal = self.freq[val]
        if currVal == len(self.stacks):
            self.stacks.append([])
        self.stacks[currVal].append(val)
        

    def pop(self) -> int:
        val_to_pop = self.stacks[-1].pop()
        self.freq[val_to_pop] -= 1
        if not self.stacks[-1]:
            self.stacks.pop()
        return val_to_pop
        


# Your FreqStack object will be instantiated and called as such:
# obj = FreqStack()
# obj.push(val)
# param_2 = obj.pop()