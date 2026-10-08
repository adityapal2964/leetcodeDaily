class Solution:
    def findDisappearedNumbers(self, nums: list[int]) -> list[int]:
        n = len(nums)
        i =0
        while i<n:
            pos = nums[i]-1
            if nums[i] != nums[pos]:
                nums[i], nums[pos] = nums[pos], nums[i]
            else:
                i+=1
        ans = []
        for k in range(n):
            if nums[k]!= k+1:
                ans.append(k+1)
        return ans