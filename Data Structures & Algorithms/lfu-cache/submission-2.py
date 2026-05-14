class Node:
    def __init__(self, key: int, value: int) -> None:
        self.key: int = key
        self.value: int = value
        self.freq: int = 1
        self.prev: Node | None = None
        self.next: Node | None = None

    def __repr__(self) -> str:
        return f"Node: {self.key} :: {self.value}"


class DoubleLinkedList:
    def __init__(self) -> None:
        self.head, self.tail = Node(-1, -1), Node(-1, -1)
        self.head.next, self.tail.prev = self.tail, self.head
        self.size = 0

    def add_to_head(self, node: Node):
        node.prev, node.next = self.head, self.head.next
        self.head.next.prev = node
        self.head.next = node
        self.size += 1

    def remove_node(self, node: Node):
        node.prev.next, node.next.prev = node.next, node.prev
        node.prev, node.next = None, None
        self.size -= 1

    def remove_from_tail(self) -> Node:
        node = self.tail.prev
        self.remove_node(node)
        return node


class LFUCache:
    def __init__(self, capacity: int):
        self.cap = capacity
        self.size = 0
        self.node_map = {}
        self.list_map = {}
        self.lfu_count = 0

    def __update_freq(self, node: Node):
        list: DoubleLinkedList = self.list_map[node.freq]
        list.remove_node(node)

        if node.freq == self.lfu_count and list.size == 0:
            self.lfu_count += 1

        node.freq += 1
        list = self.list_map.setdefault(node.freq, DoubleLinkedList())
        list.add_to_head(node)

    def get(self, key: int) -> int:
        if key not in self.node_map:
            return -1
        node: Node = self.node_map[key]
        self.__update_freq(node)
        return node.value

    def put(self, key: int, value: int) -> None:
        if key in self.node_map:
            node: Node = self.node_map[key]
            node.value = value
            self.__update_freq(node)
        else:
            if len(self.node_map) == self.cap:
                list: DoubleLinkedList = self.list_map[self.lfu_count]
                node = list.remove_from_tail()
                self.node_map.pop(node.key)
            node = Node(key, value)
            self.node_map[key] = node
            list: DoubleLinkedList = self.list_map.setdefault(1, DoubleLinkedList())
            list.add_to_head(node)
            self.lfu_count = 1


# Your LFUCache object will be instantiated and called as such:
# obj = LFUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
