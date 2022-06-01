package programmers_lv2;

public class 피보나치수 {
    public int solution(int n) {
        // 방법 1 - 속도 더 빠름
        long[] arr = new long[n + 1];
        arr[0] = 0L;
        arr[1] = 1L;

        for(int i = 2; i <= n; i++){
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1234567L;
        }

        return (int) arr[n];

        // 방법 2
//         BigInteger[] arr = new BigInteger[n + 1];
//         arr[0] = BigInteger.valueOf(0);
//         arr[1] = BigInteger.valueOf(1);

//         for(int i = 2; i <= n; i++){
//             arr[i] = arr[i - 1].add(arr[i - 2]);
//         }

//         return arr[n].remainder(BigInteger.valueOf(1234567)).intValue();
    }
}
