/**
 * 岛屿数量
 *
 * @param grid
 * @return
 */
public int numIslands(char[][] grid) {
    int n = grid.length;
    if (n == 0) {
        return 0;
    }
    int m = grid[0].length;
    int count = 0;
    for (int indexN = 0; indexN < n; indexN++) {
        for (int indexM = 0; indexM < m; indexM++) {
            if (grid[indexN][indexM] == '1') {
                processNumIslands(grid, n, m, indexN, indexM);
                count++;
            }
        }
    }
    return count;
}

private void processNumIslands(char[][] grid, int n, int m, int i, int j) {
    if (i < 0 || j < 0 || i > n || j > m || grid[i][j] != '1') {
        return;
    }
    grid[i][j] = '0';
    processNumIslands(grid, n, m, i + 1, j);
    processNumIslands(grid, n, m, i - 1, j);
    processNumIslands(grid, n, m, i, j + 1);
    processNumIslands(grid, n, m, i, j - 1);
}

/**
 * 买卖股票的最佳时机 买多次
 *
 * @param prices
 * @return
 */
public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0 || prices.length == 1) {
        return 0;
    }
    int result = 0;
    for (int day = 0; day < prices.length - 1; day++) {
        if (prices[day+1] > prices[day]) {
            result += prices[day+1] - prices[day];
        }
    }
    return result;
}
/**
 * 买卖股票的最佳时机 买1次
 *
 * @param prices
 * @return
 */
public int maxProfit2(int[] prices) {
    if (prices == null || prices.length == 0 || prices.length == 1) {
        return 0;
    }
    int result = 0;
    for (int day = 0; day < prices.length - 1; day++) {
        for (int sellDay = day+1; sellDay < prices.length; sellDay++) {
            if (prices[sellDay] > prices[day]) {
                result = Math.max(prices[sellDay] - prices[day], result);
            }
        }
    }
    return result;
}