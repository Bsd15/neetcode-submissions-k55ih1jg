class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        task_map = [0] * 26
        A = ord('A')
        for t in tasks:
            task_map[ord(t) - A] += 1
        
        cool_down_queue = []
        task_heap = []
        for task in task_map:
            if task:
                heapq.heappush_max(task_heap, task)

        cycle = 0

        while task_heap or cool_down_queue:
            if cool_down_queue and cycle >= cool_down_queue[0][1]:
                heapq.heappush_max(task_heap, cool_down_queue.pop(0)[0])

            curr_task = heapq.heappop_max(task_heap)
            if curr_task > 1:
                curr_task -= 1
                cool_down_queue.append([curr_task, cycle + 1 + n])

            if not task_heap and cool_down_queue:
                cycle = cool_down_queue[0][1]
            else:
                cycle += 1
        
        return cycle


        
