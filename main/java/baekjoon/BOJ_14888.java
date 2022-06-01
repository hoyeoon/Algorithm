package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888 {
	static int n, maxSum, minSum;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		maxSum = Integer.MIN_VALUE;
		minSum = Integer.MAX_VALUE;
		arr = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		// 배열에 숫자 담기
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");

		// 배열에 연산자 담기

		int plus = Integer.parseInt(st.nextToken());
		int minus = Integer.parseInt(st.nextToken());
		int mul = Integer.parseInt(st.nextToken());
		int div = Integer.parseInt(st.nextToken());

		dfs(0, plus, minus, mul, div, arr[0]);

		System.out.println(maxSum);
		System.out.println(minSum);
	}

	static void dfs(int cnt, int plus, int minus, int mul, int div, int sum) {
		if(cnt == n - 1){
			maxSum = Math.max(maxSum, sum);
			minSum = Math.min(minSum, sum);
			return;
		}

		if(plus > 0) dfs(cnt + 1, plus - 1, minus, mul, div, sum + arr[cnt + 1]);
		if(minus > 0) dfs(cnt + 1, plus, minus - 1, mul, div, sum - arr[cnt + 1]);
		if(mul > 0) dfs(cnt + 1, plus, minus, mul - 1, div, sum * arr[cnt + 1]);
		if(div > 0) dfs(cnt + 1, plus, minus, mul, div - 1, sum / arr[cnt + 1]);
	}
}
