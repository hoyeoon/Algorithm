package swea;

import java.util.Scanner;

public class swea_2019 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		sc.close();
		
		for(int i = 0; i <= n; i++) {
			sb.append((int)Math.pow(2, i)).append(" ");
		}
		System.out.println(sb);
	}
}
