package baekjoon;

import java.util.Scanner;

public class BOJ_3460 {
	public static void main(String[] args) {
		StringBuilder sb;
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int n;
		
		while(T-- > 0) {
			n = sc.nextInt();
			int loc = 0;
			sb = new StringBuilder();
			
			while(n != 0) {
				if(n % 2 == 1) {
					sb.append(loc).append(" ");
				}
				loc++;
				n /= 2;
			}
			System.out.println(sb);
		}
		sc.close();
	}
}
