package baekjoon;

import java.util.Scanner;

public class BOJ_1292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int arr[] = new int[1001];
		int idx = 1;
		int num = 1;
		int answer = 0;
		
		outer : while(true) {
			for(int i = 0; i < num; i++) {
				if(idx > 1000) break outer;
				arr[idx] = num;
				idx++;
			}
			num++;
		}
		
		for(int i = a; i <= b; i++) {
			answer += arr[i];
		}
		
		System.out.println(answer);
		
		sc.close();
	}
}
