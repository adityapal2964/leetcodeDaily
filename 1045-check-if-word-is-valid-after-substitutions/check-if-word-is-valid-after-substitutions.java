class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if(n%3!=0)return false;
        char[] st = new char[n];
        int top = 0;
        for(int i =0;i<n;i++){
            st[top++] = s.charAt(i);

            if(
                top >= 3 &&
                st[top-1] == 'c' &&
                st[top-2] == 'b' &&
                st[top-3] == 'a'
            )top -= 3;
        }
        return top == 0;
    }
}