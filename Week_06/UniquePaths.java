public class UniquePaths {

    /**
     * 不同路径
     * 
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     * 问总共有多少条不同的路径？
     * 
     */
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        for (int i = 0; i < m; i++) {
            paths[i][n-1] = 1;
        }
        for (int j = 0; j < n; j++) {
            paths[m-1][j] = 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >=0; j--) {
                paths[i][j] = paths[i][j+1] + paths[i+1][j];
            }
        }
        return paths[0][0];
    }

    /**
     * 不同路径 2
     * 
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     * 
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = 0;
        if (m > 0) {
            n = obstacleGrid[0].length;
        }
        int[][] paths = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                int start = i;
                do {
                    paths[start][0] = 0;
                    start++;
                } while (start < m);
                break;
            }
            paths[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                int start = j;
                do {
                    paths[0][start] = 0;
                    start++;
                } while (start < n);
                break;
            }
            paths[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                paths[i][j] = obstacleGrid[i][j] == 1? 0 : paths[i][j-1] + paths[i-1][j];
            }
        }
        return paths[m-1][n-1];
    }
}