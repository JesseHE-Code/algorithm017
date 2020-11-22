// 有多少个1
public int hammingWeight(int n) {
    if (n == 0) {
        return 0;
    }
    int count = 0;
    while (n != 0) {
        n = n & (n - 1);
        count++;
    }
    return count;
}


// 是否为2的n次幂
public boolean isPowerOfTwo(int n) {
    if (n == 0) return false;
    long x = (long) n;
    return (x & (x - 1)) == 0;
}




