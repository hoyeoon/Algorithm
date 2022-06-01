package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1978 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int primeCnt = 0;
		
		for(int i = 0; i < N; i++) {
			if(isPrime(Integer.parseInt(st.nextToken())) == 1) primeCnt++;
		}
		
		System.out.println(primeCnt);
	}
	
	private static int isPrime(int n) {
		if(n == 1) return 0;
		
		for(int i = 2; i <= (int) Math.sqrt(n); i++) {
			if(n % i == 0) return 0;
		}
		return 1;
	}
}
