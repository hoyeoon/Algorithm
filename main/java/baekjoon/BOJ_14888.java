package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888 {
	static int maxValue = Integer.MIN_VALUE;
	static int minValue = Integer.MAX_VALUE;
	static int[] arr;
	static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
		arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		int plus = Integer.parseInt(st.nextToken());
		int minus = Integer.parseInt(st.nextToken());
		int multiply = Integer.parseInt(st.nextToken());
		int division = Integer.parseInt(st.nextToken());

		dfs(0, plus, minus, multiply, division, arr[0]);

		System.out.println(maxValue + "\n" + minValue);
    }

	private static void dfs(int idx, int plus, int minus, int multiply, int division, int value) {
		if(idx == n - 1) {
			maxValue = Math.max(maxValue, value);
			minValue = Math.min(minValue, value);
			return;
		}

		if(plus > 0) {
			dfs(idx + 1, plus - 1, minus, multiply, division, value + arr[idx + 1]);
		}
		if(minus > 0) {
			dfs(idx + 1, plus, minus - 1, multiply, division, value - arr[idx + 1]);
		}
		if(multiply > 0) {
			dfs(idx + 1, plus, minus, multiply - 1, division, value * arr[idx + 1]);
		}
		if(division > 0) {
			dfs(idx + 1, plus, minus, multiply, division - 1, value / arr[idx + 1]);
		}
	}
}
