# 学习笔记

## 题目分析

### 1、子集

```
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
```
这个题目的解首先是会包括一个[]，这个需要注意一些

分析输入：是一个列表，当我们访问列表第一个元素的时候，此时的结果应该是：
```
[
    [],
    [1]
]
```

当我们访问列表第二个元素的时候，此时的结果应该是：
```
[
    [],
    [1],
    [2],
    [1,2]
]
```
可以看作我们在迭代列表时，在原有的列表基础上将当前元素添加进去，并在结果中添加新的解
根据这个思想，我们先来简单实现一下：
```java
/**
 * 子集
 *
 * @param nums
 * @return
 */
public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<>());
    for (int nun : nums) {
        processSubList(result, nun);
    }
    return result;
}

public void processSubList(List<List<Integer>> result, int num) {
    List<List<Integer>> processList = new ArrayList<>();
    int size = result.size();
    for (int index = 0; index < size; index++) {
        List<Integer> temp = result.get(index);
        List<Integer> newList = new ArrayList<>(temp);
        newList.add(num);
        result.add(newList);
    }
}
```
这里要注意一点：
```java
List<Integer> newList = new ArrayList<>(temp);
```
看题目的品论，有很多同学忘记new一个新的List，导致结果不正确。知道为啥吗？


### 2、POW

```
实现 pow(x, n) ，即计算 x 的 n 次幂函数。

示例 1:

输入: 2.00000, 10
输出: 1024.00000
示例 2:

输入: 2.10000, 3
输出: 9.26100
示例 3:

输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25
说明:

-100.0 < x < 100.0
n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
```

 x 的 n 次幂就是n个x相乘 或者 -n 个 1/x 相乘 ，解题第一个思路应该就是暴力求解，循环n次，连乘就好，比如：
 10的1024次幂，乘1024 次肯定可以拿到结果的。

 循环去乘可能不是最好的解法，我们思考片刻，怎样将这个循环的次数降低一点呢？

 10 的1024次幂  =  10的512次幂  * 10的512次幂  
 10 的 512次幂  =  10的256次幂  * 10的256次幂  
……  

那 x的n次幂 = x的n/2次幂   *  x的n/2次幂  
这好像是一个思路  

我们再思考一下其他情况，比如 n是奇数 ？  
x的n次幂 = x的n/2次幂   *  x的n/2次幂    * x

完美，Let's go!   

```java
/**
 * 实现POW
 *
 * @param x
 * @param n
 * @return
 */
public double myPow(double x, int n) {
    long N = n;
    if (n < 0) {
        N = -N;
        x = 1.0 / x;
    }
    return processPow(x, N);
}

public double processPow(double x, long n) {
    if (n == 0) {
        return 1.0;
    }
    double result = processPow(x, n / 2);
    if (n % 2 == 1) {
        return result * result * x;
    }
    return result * result;
}
```