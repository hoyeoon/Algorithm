package programmers_lv2;

public class _3xn타일링 {
    long[] result = new long[5001];

    public int solution(int n) {
        return fibo(n);
    }

    private int fibo(int n){
        result[2] = 3;
        result[4] = 11;

        if(n % 2 == 1){
            return 0;
        }

        for(int i = 6; i <= n; i += 2){
            result[i] = 3 * result[i - 2];

            for(int j = 6; j <= i; j += 2){
                result[i] += 2 * result[j - 4];
            }
            result[i] += 2;
            result[i] %= 1000000007;
        }

        return (int)result[n];
    }
}
