package baekjoon;

import java.util.Arrays;
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
		input = new int[R];
		visited = new boolean[N];
		numbers = new int[N];
		
		permutation(0);
		sc.close();
	}

	private static void permutation(int cnt) {
		if(cnt == R) {
			System.out.println(Arrays.toString(input));
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[cnt] = true;
				numbers[cnt] = input[i]; 
				permutation(cnt + 1);
				visited[cnt] =false;
			}
		}	
	}
}
