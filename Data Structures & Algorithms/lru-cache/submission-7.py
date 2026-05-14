class Node:
    def __init__(self, key: int, value: int) -> None:
        self.key: int = key
        self.value: int = value
        self.prev: Node | None = None
        self.next: Node | None = None

    def __repr__(self) -> str:
        return f"Node: {self.key} :: {self.value}"


class LRUCache:
    def __init__(self, capacity: int):
        self.cap = capacity
        self.head, self.tail = Node(-1, -1), Node(-1, -1)
        self.head.next = self.tail
        self.tail.prev = self.head
        self.cache = {}

    def __remove_node(self, node: Node):
        node.prev.next = node.next
        node.next.prev = node.prev

    def __add_node_to_head(self, node: Node):
        node.next = self.head.next
        node.prev = self.head

        self.head.next.prev = node
        self.head.next = node

    def get(self, key: int) -> int:
        if key not in self.cache:
            return -1
        node: Node = self.cache[key]
        self.__remove_node(node)
        self.__add_node_to_head(node)
        return node.value

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            node: Node = self.cache[key]
            node.value = value
            self.__remove_node(node)
            self.__add_node_to_head(node)
        else:
            node: Node = Node(key, value)
            self.cache[key] = node
            self.__add_node_to_head(node)
            if len(self.cache) > self.cap:
                node: Node = self.tail.prev
                self.cache.pop(node.key)
                self.__remove_node(node)
