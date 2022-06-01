package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309 {
	static StringBuilder sb = new StringBuilder();
	static int N = 9, R = 7;
	static int[] input;
	static int[] numbers;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		input = new int[N];
		numbers = new int[R];
		
		for(int i = 0; i < N; i++) {
			input[i] = sc.nextInt(); 
		}
		sc.close();
		
		combination(0, 0);
		System.out.println(sb);
	}
	
	static void combination(int cnt, int start) {
		if(cnt == R) {
			if(numberSum() == 100) {
				Arrays.sort(numbers);
				for(int i = 0; i < R; i++) {
					sb.append(numbers[i]).append("\n");
				}
			}
			return;
		}
		
		for(int i = start; i < N; i++) {
			numbers[cnt] = input[i]; 
			combination(cnt + 1, i + 1);
		}
	}
	
	static int numberSum() {
		int sum = 0;
		for(int number : numbers)
			sum += number;
		return sum;
	}
}
