class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long[] a1 = new long[n], a2 = new long[n];
        a1[0] = nums[0];
        a2[n-1] = nums[n-1];
        for(int i =1 ;i<nums.length;i++){
            a1[i] = nums[i]+ a1[i-1];
        }
        for(int i =n-2 ;i>=0;i--){
            a2[i] = nums[i]+ a2[i+1];
        }
        int cnt  = 0;
        for(int i =0;i<n-1;i++){
            if(a1[i] >= a2[i+1])cnt++;
        }
        return cnt;
    }
}