package baekjoon;

import java.util.Scanner;

public class BOJ_1463 {
	public static void main(String[] args) {
		int[] d = new int[1000001];
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		d[1] = 0;
		d[2] = 1;
		
		for(int i = 3; i <= x; i++) {
			d[i] = d[i - 1] + 1;
			if(i % 3 == 0) d[i] = Math.min(d[i], d[i / 3] + 1);
			if(i % 2 == 0) d[i] = Math.min(d[i], d[i / 2] + 1);
		}
		System.out.println(d[x]);
	}
}
