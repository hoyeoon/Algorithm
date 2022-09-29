package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_9084 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            List<Integer> coin = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                coin.add(Integer.parseInt(st.nextToken()));
            }

            int target = Integer.parseInt(br.readLine());
            int[] dp = new int[target + 1];
            dp[0] = 1;

            for (int i = 0; i < n; i++) {
                for (int j = coin.get(i); j < target + 1; j++) {
                    dp[j] = dp[j] + dp[j - coin.get(i)];
                }
            }

            System.out.println(dp[target]);
        }
    }
}
