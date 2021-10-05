package baekjoon;

import java.util.Scanner;

public class BOJ_15650 {
	static int[] numbers;
	static int[] input;
	static int N, R;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		input = new int[N];
		numbers = new int[R];
		
		for(int i = 0; i < N; i++) {
			input[i] = i + 1;
		}
		
		comb(0, 0);
		
		sc.close();
	}

	private static void comb(int cnt, int start) {
		if(cnt == R) {
			for(int number : numbers) {
				System.out.print(number + " ");
			}
			System.out.println();
			return;
		}
		for(int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			comb(cnt + 1, i + 1);
		}
	}
}
