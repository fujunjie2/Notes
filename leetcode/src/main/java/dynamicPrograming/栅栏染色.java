package dynamicPrograming;

public class 栅栏染色 {

    public static void main(String[] args) {
        int k = solution(10,3);

        System.out.println(k);
    }

    public static int solution(int n, int k) {

        if (n == 0)
            return 0;
        if (n == 1)
            return k;

        int[] w = new int[n];
        w[0] = k;
        w[1] = k * k;

        int select = k-1;

        for (int i = 2; i < n; ++i) {
            w[i] = (w[i - 1] + w[i - 2]) * select;
        }
        return w[n-1];
    }
}
