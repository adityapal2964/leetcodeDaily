class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int ans = 0;
        int m = values[0];
        for(int j =1;j<n;j++){
            if(values[j]-j +m > ans)
                ans = m+values[j]-j;
            if(values[j]+j>m)
                m = values[j]+j;
        }
        return ans;
    }
}