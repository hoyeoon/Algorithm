package baekjoon;

import java.util.Scanner;

public class BOJ_2581 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int minPrime = 0;
		int sumPrime = 0;
		
		for(int i = m; i <= n; i++) {
			if(isPrime(i) == 1) {
				if(minPrime == 0) minPrime = i;
				sumPrime += i;
			}
		}
		
		if(sumPrime > 0) {
			System.out.println(sumPrime);
			System.out.println(minPrime);
		} else {
			System.out.println(-1);
		}
		
		sc.close();
	}
	
	private static int isPrime(int n) {
		if(n == 1) return 0;
		
		for(int i = 2; i <= (int) Math.sqrt(n); i++) {
			if(n % i == 0) return 0;
		}
		return 1;
	}
}
