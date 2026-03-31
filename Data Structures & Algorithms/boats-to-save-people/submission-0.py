class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        people.sort()
        left = 0
        right = len(people) - 1
        res = 0
        while left <= right:
            res += 1
            if left == right:
                left += 1
            else:
                total_weight = people[left] + people[right]
                if total_weight <= limit:
                    left += 1
                    right -= 1
                else:
                    if people[left] >= people[right]:
                        left += 1
                    else:
                        right -= 1
        return res