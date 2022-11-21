class Solution {

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int islands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    drawTreeForComponent(i, j, grid, visited);
                    islands++;
                }
            }
        }

        return islands;
    }

    public void drawTreeForComponent(int i, int j, char[][] grid, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0' || visited[i][j] == true) {
            return;
        }

        visited[i][j] = true;
        drawTreeForComponent(i - 1, j, grid, visited);
        drawTreeForComponent(i, j + 1, grid, visited);
        drawTreeForComponent(i + 1, j, grid, visited);
        drawTreeForComponent(i, j - 1, grid, visited);
    }
}
