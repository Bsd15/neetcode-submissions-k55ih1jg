class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if len(prices) == 1:
            return prices[0]
        
        profit = 0
        bp = prices[0]
        for p in prices:
            if p <= bp:
                bp = p
            else:
                profit += p - bp
                bp = p
        return profit