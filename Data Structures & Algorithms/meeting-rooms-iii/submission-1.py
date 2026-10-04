class Solution:
    def mostBooked(self, n: int, meetings: List[List[int]]) -> int:
        # sorted(meetings, key = lambda x: x[0])
        meetings.sort(key = lambda x: x[0])
        meeting_rooms_min_queue = []
        for i in range(n):
            heapq.heappush(meeting_rooms_min_queue, i)
        usage_count = [0] * n
        meetings_min_queue = []
        for meeting in meetings:
            start, end = meeting
            while meetings_min_queue and meetings_min_queue[0][0] <= start:
                meeting_end, room = heapq.heappop(meetings_min_queue)
                heapq.heappush(meeting_rooms_min_queue, room)
            if not meeting_rooms_min_queue:
                meeting_end, room = heapq.heappop(meetings_min_queue)
                end = meeting_end + (end - start)
                heapq.heappush(meeting_rooms_min_queue, room)
            room = heapq.heappop(meeting_rooms_min_queue)
            heapq.heappush(meetings_min_queue, (end, room))
            usage_count[room] += 1
        max_usage = 0
        res = 0
        for i in range(n):
            if usage_count[i] > max_usage:
                max_usage = usage_count[i]
                res = i
        return res