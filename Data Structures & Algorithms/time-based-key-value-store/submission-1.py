class TimeMap:

    def __init__(self):
        self.time_map = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.time_map:
            self.time_map[key] = []
        self.time_map[key].append([timestamp, value])

    def get(self, key: str, timestamp: int) -> str:
        if key not in self.time_map:
            return ""
        vals = self.time_map[key]
        print(vals)
        l, r = 0, len(vals) - 1
        while l <= r:
            m = l + (r - l) // 2
            if vals[m][0] == timestamp:
                return vals[m][1]
            elif timestamp < vals[m][0]:
                r = m - 1
            else:
                l = m + 1
        if r >= 0:
            return vals[r][1]
        else:
            return ""

