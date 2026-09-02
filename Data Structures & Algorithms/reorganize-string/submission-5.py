class Solution:
    def reorganizeString(self, s: str) -> str:
        # 1. Count frequencies
        freq_count = {}
        max_freq = 0
        max_char = ''
        
        for c in s:
            freq_count[c] = freq_count.get(c, 0) + 1
            if freq_count[c] > max_freq:
                max_freq = freq_count[c]
                max_char = c
                
        # Impossible case
        if max_freq > (len(s) + 1) // 2:
            return ""
            
        # 2. Prepare an array for the result
        res = [''] * len(s)
        index = 0
        
        # 3. Place the most frequent character at even indices first
        while freq_count[max_char] > 0:
            res[index] = max_char
            index += 2
            freq_count[max_char] -= 1
            
        # 4. Place all the remaining characters
        for char, count in freq_count.items():
            while count > 0:
                # If we reach the end of even indices, wrap to odd indices
                if index >= len(s):
                    index = 1
                    
                res[index] = char
                index += 2
                count -= 1
                
        return "".join(res)