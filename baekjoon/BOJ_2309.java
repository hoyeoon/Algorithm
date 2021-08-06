package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309 {
	static int[] numbers;
	static int[] input;
	static int sum;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		numbers = new int[7];
		input = new int[9];
		
		for(int i = 0; i < 9; i++) {
			input[i] = sc.nextInt();
		}
		System.out.println(Arrays.toString(input));
		combination(0, 1);
	}
	private static void combination(int cnt, int start) {
		if(cnt == 7) {
			int sum = 0;
			for(int i = 0; i < 7; i++) {
				sum += input[numbers[i] - 1];
			}
			if(sum == 100) {
				System.out.println("무야호");
			}
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i = start; i <= 9; i++) {
			numbers[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}
}
