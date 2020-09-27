import utils.ListUtils;

public class LeeCodeTask {

    /**
     * 猜数字游戏
     *
     * @param secret
     * @param guess
     * @return
     */
    public String getHint(String secret, String guess) {
        int len = secret.length();
        int[] cache = new int[10];
        int x = 0, y = 0;
        for (int i = 0; i < len; i++) {
            char cs = secret.charAt(i);
            char cg = guess.charAt(i);
            if (cs == cg) {
                x++;
            } else {
                if (cache[cs - '0']++ < 0) y++;
                if (cache[cg - '0']-- > 0) y++;
            }
        }
        return x + "A" + y + "B";
    }

    /**
     * 旋转数组
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if (nums.length < k) {
            k = nums.length % k;
        }
        int[] temp = new int[nums.length - k];
        System.arraycopy(nums, 0, temp, 0, nums.length - k);
        System.arraycopy(nums, nums.length - k, nums, 0, k);
        System.arraycopy(temp, 0, nums, k, nums.length - k);
    }

    /**
     * 合并两个有序数组
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge(int[] A, int m, int[] B, int n) {
        if (m == 0) {
            System.arraycopy(B, 0, A, 0, n);
            return;
        }
        if (n == 0) {
            return;
        }
        int indexA = 0;
        int indexB = 0;
        do {
            if (A[indexA + indexB] >= B[indexB]) {
                System.arraycopy(A, indexA + indexB, A, indexA + indexB + 1, m - indexA);
                A[indexA + indexB] = B[indexB];
                indexB++;
            } else {
                indexA++;
            }
        } while (indexA < m  && indexB < n );

        if (indexA == m ) {
            System.arraycopy(B, indexB , A, indexA + indexB  , n - indexB);
        }
    }

    public static void main(String[] args) {
        LeeCodeTask leeCodeTask = new LeeCodeTask();
        System.out.println(leeCodeTask.getHint("1807", "7810"));
        System.out.println(leeCodeTask.getHint("1123", "0111"));
        System.out.println(leeCodeTask.getHint("11", "10"));
        System.out.println(leeCodeTask.getHint("11", "01"));

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        leeCodeTask.rotate(nums, 5);
        ListUtils.printList(nums);

        int[] sortNumsA = {1,2,3,0,0,0};
        int[] sortNumsB = {2,5,6};
        ListUtils.printList(sortNumsA);
        ListUtils.printList(sortNumsB);
        leeCodeTask.merge(sortNumsA, 3, sortNumsB, 3);
        ListUtils.printList(sortNumsA);

        int[] sortNumsA1 = {0};
        int[] sortNumsB1 = {1};
        ListUtils.printList(sortNumsA1);
        ListUtils.printList(sortNumsB1);
        leeCodeTask.merge(sortNumsA1, 0, sortNumsB1, 1);
        ListUtils.printList(sortNumsA1);

        int[] sortNumsA2 = {1};
        int[] sortNumsB2 = {1};
        ListUtils.printList(sortNumsA2);
        ListUtils.printList(sortNumsB2);
        leeCodeTask.merge(sortNumsA2, 0, sortNumsB2, 1);
        ListUtils.printList(sortNumsA1);
    }
}

