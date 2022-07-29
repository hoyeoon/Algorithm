package programmers_lv2;

public class _2xn타일링 {
    int[] result = new int[60001];

    public int solution(int n) {
        return fibo(n);
    }

    private int fibo(int n){
        result[1] = 1;
        result[2] = 2;

        for(int i = 3; i <= n; i++){
            result[i] = (result[i - 1] + result[i - 2]) % 1000000007;
        }

        return result[n];
    }
}
