class Solution {
    int n, m;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    private void bfs(int[][] heights, boolean[][] vis, Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < m &&
                    !vis[nr][nc] &&
                    heights[nr][nc] >= heights[r][c]) {

                    vis[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n = heights.length;
        m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        Queue<int[]> pq = new LinkedList<>();
        Queue<int[]> aq = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            pacific[i][0] = true;
            pq.offer(new int[]{i, 0});

            atlantic[i][m - 1] = true;
            aq.offer(new int[]{i, m - 1});
        }

        for (int j = 0; j < m; j++) {
            pacific[0][j] = true;
            pq.offer(new int[]{0, j});

            atlantic[n - 1][j] = true;
            aq.offer(new int[]{n - 1, j});
        }

        bfs(heights, pacific, pq);
        bfs(heights, atlantic, aq);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }
}