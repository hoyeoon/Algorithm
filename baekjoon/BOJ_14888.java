package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888 {
	static int n, maxVal, minVal;
	static char[] ops;
	static char[] output_ops;
	static boolean[] visited;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		ops = new char[n - 1];
		output_ops = new char[n - 1];
		visited = new boolean[n - 1];
		maxVal = Integer.MIN_VALUE;
		minVal = Integer.MAX_VALUE;
		arr = new int[n];
		int idx = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		
		// 배열에 숫자 담기
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		
		// 배열에 연산자 담기
		for(int i = 0; i < 4; i++) {
			int cnt = Integer.parseInt(st.nextToken());
			char op = '\0';
			
			switch(i) {
			case 0:
				op = '+';
				break;
			case 1:
				op = '-';
				break;
			case 2:
				op = '*';
				break;
			case 3:
				op = '/';
				break;
			}
			
			for(int j = idx; j < idx + cnt; j++) {
				ops[j] = op;
			}
			idx += cnt;
		}
		
		permutation(0);
		
		System.out.println(maxVal);
		System.out.println(minVal);
		
	}
	
	static void permutation(int cnt) {
		if(cnt == n - 1) {
			int val = arr[0];
			
			for(int i = 0; i < n - 1; i++) {
				switch(output_ops[i]) {
				case '+':
					val += arr[i + 1];
					break;
				case '-':
					val -= arr[i + 1];
					break;
				case '*':
					val *= arr[i + 1];
					break;
				case '/':
					val /= arr[i + 1];
					break;
				}
			}
			maxVal = Math.max(maxVal, val);
			minVal = Math.min(minVal, val);
			return;
		}
		
		for(int i = 0; i < n - 1; i++) {
			if(!visited[i]) {
				output_ops[cnt] = ops[i];
				visited[i] = true;
				
				permutation(cnt + 1);
				visited[i] = false;
			}
		}
	}
}
