class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        s1_len = len(s1)
        s2_len = len(s2)

        if s1_len > s2_len:
            return False
        
        s1_counts = [0] * 26
        s2_counts = [0] * 26
        a = ord('a')
        for i in range(s1_len):
            s1_counts[ord(s1[i]) - a] += 1
            s2_counts[ord(s2[i]) - a] += 1
        
        matches = 0

        for i in range(26):
            matches += 1 if s1_counts[i] == s2_counts[i] else 0
        
        l = 0
        for r in range(s1_len, s2_len):
            if matches == 26:
                return True
            
            i = ord(s2[r]) - a
            s2_counts[i] += 1

            # 3 possible conditions
            # 1. s1_count[i] != s2_counts[i], By incrementing we made s1_counts[i] = s2_counts[i]; so increment matches
            # 2. s1_counts[i] == s2_counts[i], but by incrementing s2_count[i] we broke that equality, so we decrement matches (as its a new missmatch)
            # 3. s1_count[i] != s2_counts[i], so incrementing it still s1_count[i] != s2_counts[i]; so we dont have to do anything
            if s1_counts[i] == s2_counts[i]:
                matches += 1
            elif s1_counts[i] + 1 == s2_counts[i]:
                matches -= 1

            i = ord(s2[l]) - a
            s2_counts[i] -= 1

            # 3 possible conditions
            # 1. s1_count[i] != s2_counts[i], By decrementing we made s1_counts[i] = s2_counts[i]; so increment matches
            # 2. s1_counts[i] == s2_counts[i], but by decrementing s2_count[i] we broke that equality, so we decrement matches (as its a new missmatch)
            # 3. s1_count[i] != s2_counts[i], so decrementing it still s1_count[i] != s2_counts[i]; so we dont have to do anything
            if s1_counts[i] == s2_counts[i]:
                matches += 1
            elif s1_counts[i] - 1 == s2_counts[i]:
                matches -= 1
            
            l += 1
        return matches == 26