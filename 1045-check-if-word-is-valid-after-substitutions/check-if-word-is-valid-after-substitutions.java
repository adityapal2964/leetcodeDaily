class Solution {
    public boolean isValid(String s) {
        if(s.length()%3 != 0)return false;
        if(s.length()== 0 || s.equals("abc"))return true;
        for(int i =0;i<s.length()-2;i++){
            if(s.substring(i, i+3).equals("abc")){
                return isValid(s.substring(0,i)+(i+3 < s.length()?(s.substring(i+3)):""));
            }
        }
        return false;
    }
}