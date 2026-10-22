
class Solution {
    String s, t, u;
    Boolean[][] memo;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }

        this.s = s1;
        this.t = s2;
        this.u = s3;
        this.memo = new Boolean[s.length() + 1][t.length() + 1];

        return solve(0, 0);
    }

    boolean solve(int i, int j) {
        if (i == s.length() && j == t.length()) {
            return true;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        int k = i + j;
        boolean ans = false;

        if (i < s.length() && s.charAt(i) == u.charAt(k)) {
            ans = solve(i + 1, j);
        }

        if (!ans && j < t.length() && t.charAt(j) == u.charAt(k)) {
            ans = solve(i, j + 1);
        }

        return memo[i][j] = ans;
    }
}
