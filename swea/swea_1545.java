package swea;

import java.util.Scanner;

public class swea_1545 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		sc.close();
		
		for(int i = n; i >= 0; i--) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}
}
