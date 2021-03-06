# 学习笔记

## 位运算总结

### 指定位置的位运算

+ 将 x 最右边的 n 位清零:x & (~0 << n)
+ 获取 x 的第 n 位值(0 或者 1): (x >> n) & 1
+ 获取 x 的第 n 位的幂值:x & (1 << n)
+ 仅将第 n 位置为 1:x | (1 << n)
+ 仅将第 n 位置为 0:x & (~ (1 << n))
+ 将 x 最高位至第 n 位(含)清零:x & ((1 << n) - 1)

### 实战位运算要点

+ 判断奇偶:
    + x % 2 == 1 —> (x & 1) == 1
    + x % 2 == 0 —> (x & 1) == 0
+ x >> 1 —> x / 2.
    + 即: x = x / 2; —> x = x >> 1;
    + mid = (left + right) / 2; —> mid = (left + right) >> 1;
+ X = X & (X-1) 清零最低位的 1
+ X & -X => 得到最低位的 1
+ X & ~X => 0
