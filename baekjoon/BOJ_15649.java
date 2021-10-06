package baekjoon;

import java.util.Scanner;

public class BOJ_15649 {
	static int N, R;
	static int[] input;
	static int[] numbers;
	static boolean[] visited;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		visited = new boolean[N];
		numbers = new int[R];
		
		for(int i = 0; i < N; i++) {
			input[i] = i + 1;
		}
		permutation(0);
		System.out.println(sb);
		sc.close();
	}

	private static void permutation(int cnt) {
		if(cnt == R) {
			for(int number : numbers) {
				sb.append(number).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				numbers[cnt] = input[i];
				permutation(cnt + 1);
				visited[i] = false;
			}
		}
	}
}
