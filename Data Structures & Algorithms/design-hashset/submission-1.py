class MyHashSet:

    def __init__(self):
        self.LOAD_FACTOR = 0.75
        self.hash_table = [None] * 16
        self.capacity = 16
        self.size = 0
    
    def calc_hash(self, element: int) -> int:
        return element % self.capacity

    def add(self, key: int) -> None:

        def resize():
            new_capacity = self.capacity * self.capacity
            new_hash_table = [None] * new_capacity
            prev_hash_table = self.hash_table
            self.hash_table = new_hash_table
            self.capacity = new_capacity
            for e in prev_hash_table:
                if e is None:
                    continue
                self.add(e)

        if (self.contains(key)): 
            return
        idx = self.calc_hash(key)
        while self.hash_table[idx] is not None:
            idx = (idx + 1) % self.capacity
        self.hash_table[idx] = key
        self.size += 1
        if self.size >= self.capacity * self.LOAD_FACTOR:
            resize()

    def remove(self, key: int) -> None:
        if not self.contains(key):
            return
        idx = self.calc_hash(key)
        while self.hash_table[idx] != key:
            idx = (idx + 1) % self.capacity
        self.hash_table[idx] = None
        self.size -= 1
        idx = (idx + 1) % self.capacity
        while self.hash_table[idx]:
            element = self.hash_table[idx]
            self.hash_table[idx] = None
            self.size -= 1
            self.add(element)
            idx = (idx + 1) % self.capacity

    def contains(self, key: int) -> bool:
        if self.size == 0:
            return False
        idx = self.calc_hash(key)
        while self.hash_table[idx] is not None:
            if self.hash_table[idx] == key:
                return True
            idx = (idx + 1) % self.capacity
        return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)