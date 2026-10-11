class Solution {
    boolean[][] vis;
    int maxRow, maxCol;

    public int[][] findFarmland(int[][] land) {
        int n = land.length;
        int m = land[0].length;

        vis = new boolean[n][m];
        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !vis[i][j]) {
                    maxRow = i;
                    maxCol = j;

                    dfs(land, i, j);

                    ans.add(new int[]{i, j, maxRow, maxCol});
                }
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }

    void dfs(int[][] land, int i, int j) {
        int n = land.length;
        int m = land[0].length;

        if (i < 0 || j < 0 || i >= n || j >= m ||
            land[i][j] == 0 || vis[i][j]) {
            return;
        }

        vis[i][j] = true;

        maxRow = Math.max(maxRow, i);
        maxCol = Math.max(maxCol, j);

        dfs(land, i + 1, j);
        dfs(land, i - 1, j);
        dfs(land, i, j + 1);
        dfs(land, i, j - 1);
    }
}