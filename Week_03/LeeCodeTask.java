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