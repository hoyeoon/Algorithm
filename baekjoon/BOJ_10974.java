package baekjoon;

import java.util.Scanner;

public class BOJ_10974 {
	static int N, R;
	static int[] input;
	static int[] numbers;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = N;
		input = new int[N];
		for(int i = 1; i <= N; i++) {
			input[i - 1] = i;
		}
		visited = new boolean[N];
		numbers = new int[R];
		
		permutation(0);
		sc.close();
	}

	private static void permutation(int cnt) {
		if(cnt == R) {
			for(int i : numbers) {
				System.out.print(i + " ");
			}
			System.out.println();
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
