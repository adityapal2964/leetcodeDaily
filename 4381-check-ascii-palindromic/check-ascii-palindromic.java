class Solution {
    public boolean isPalindromic(String s) {
        int n = s.length();
        String ans = "";
        for(int i =0;i<n;i++){
            char ch = s.charAt(i);
            String paddedBinaryStr = String.format("%8s", Integer.toBinaryString(ch)).replace(' ', '0');
            ans+=paddedBinaryStr;
        }

        return isPal(ans);
    }
    boolean isPal(String s){
        int i =0, j = s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))return false;
            i++;j--;
        }
        return true;
    }
}