class Solution:
    def findMaxConsecutiveOnes(self, nums: list[int]) -> int:
        cnt = 0
        maxi = 0
        for i in nums:
            if(i == 0):
                maxi = max(maxi, cnt)
                cnt = 0
            else:
                cnt+=1
        if cnt > maxi:
            return cnt
        return maxi