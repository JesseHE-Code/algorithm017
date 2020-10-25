# 学习笔记

## 题目分析

### 1、岛屿的数量

```
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
此外，你可以假设该网格的四条边均被水包围。
示例 1：

输入：grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
输出：1
示例 2：

输入：grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
输出：3
```

岛屿是由1构成的，只要1的上下左右都是0，那这就是一个独立的岛屿。在分析到这里，我们可以思考一下，如果遍历矩阵，你遇到一个1，就需要找到它周围所有相连接的1就可以了，这些相连的1都是属于该岛屿的，你把这些1做一个标记，标记完，去寻找下一个岛屿。  
标记这个事情有技巧，除了标记，我们可以考虑，为了不影响寻找下一个岛屿，其实我们可以把标记动作转换成置0操作，那我们看一下代码实现：

```java
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
```
分析：遍历数组，遇到1，我们进行本次岛屿的标记，标记结束后，岛屿数量 +1 。至于“标记”动作，递归实现就可。

### 2、买卖股票的最佳时机
```
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。

注意：你不能在买入股票前卖出股票。

 

示例 1:

输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
示例 2:

输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
```

这个题目有一个规则，就是前一天买，后面可以抛售，买入价格和售出价格之差即是利润。我门只需要判断啥时候买入，啥时候抛出即可。  
啥时候买入？ 第一天的股票比第二天低就买入，这样才能保证能够赚到钱。（贪心算法思想）

```java
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
```