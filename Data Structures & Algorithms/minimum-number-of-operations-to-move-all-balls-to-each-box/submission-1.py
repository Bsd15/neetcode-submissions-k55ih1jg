class Solution:
    def minOperations(self, boxes: str) -> List[int]:
        res = [0] * len(boxes)

        balls = moves = 0
        for i in range(len(boxes)):
            res[i] += balls + moves
            moves += balls
            balls+= int(boxes[i])
        
        balls = moves = 0
        for i in range(len(boxes) - 1, -1, -1):
            res[i] += balls + moves
            moves += balls
            balls+= int(boxes[i])

        return res