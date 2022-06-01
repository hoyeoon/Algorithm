package baekjoon;

import java.util.Scanner;

public class BOJ_2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = n / 5;
		int answer = Integer.MAX_VALUE;
		
		for(int i = 0; i <= cnt; i++) {
			int r = n - i * 5;
			
			if(r % 3 == 0) {
				answer = Math.min(answer, i + r / 3);
			}
		}
		if(answer == Integer.MAX_VALUE) 
			answer = -1;
		System.out.println(answer);
		sc.close();
	}
}
