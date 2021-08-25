package baekjoon;

import java.util.Scanner;

public class BOJ_2292 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		if(N == 1) {
			System.out.println(1);
			return;
		}
		
		int init = 2;
		int value = init;
		int n = 2;
		
		while(true) {
			if(value > N) break;
			value = init + 3 * n * (n - 1);
			n++;	
		}
		
		System.out.println(n - 1);
		sc.close();
	}
}
