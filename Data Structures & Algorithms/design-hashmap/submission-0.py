class MyHashMap:

    def __init__(self):
        self.LOAD_FACTOR = 0.75
        self.hash_table = [None] * 16
        self.capacity = 16
        self.size = 0
    
    def calc_hash(self, element: int) -> int:
        return element % self.capacity

    def put(self, key: int, value: int) -> None:
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

        if self.get(key) == value:
            print("25 " + self.get(key)) 
            return
        idx = self.calc_hash(key)
        while self.hash_table[idx] is not None and self.hash_table[idx][0] != key:
            idx = (idx + 1) % self.capacity
        self.hash_table[idx] = [key, value]
        self.size += 1
        if self.size >= self.capacity * self.LOAD_FACTOR:
            resize()

    def get(self, key: int) -> int:
        if self.size == 0:
            return -1
        idx = self.calc_hash(key)
        while self.hash_table[idx] is not None:
            if self.hash_table[idx][0] == key:
                return self.hash_table[idx][1]
            idx = (idx + 1) % self.capacity
        return -1

    def remove(self, key: int) -> None:
        if self.get(key) == -1:
            return
        idx = self.calc_hash(key)
        while self.hash_table[idx][0] != key:
            idx = (idx + 1) % self.capacity
        self.hash_table[idx] = None
        self.size -= 1
        idx = (idx + 1) % self.capacity
        while self.hash_table[idx]:
            element = self.hash_table[idx]
            self.hash_table[idx] = None
            self.size -= 1
            self.put(element[0], element[1])
            idx = (idx + 1) % self.capacity


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)