package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_12851 {
	static boolean visited[] = new boolean[101];
	static int N, K, min_sec = Integer.MAX_VALUE, cnt = 0;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		sc.close();
		
		dfs(0, N);
		
		System.out.println(min_sec);
		System.out.println(cnt);
		
		System.out.println(Arrays.toString(visited));
	}
	
	private static void dfs(int sec, int X) {
		System.out.print(X);
		if(X > 100 || X < 0) return;
		
		if(X == K) {
			if(sec < min_sec) {
				min_sec = sec;
				cnt = 1;
			} else if(sec == min_sec) {
				cnt++;
			}
			return;
		}
		
		visited[X] = true;
		
		if(!visited[X + 1]) dfs(sec + 1, X + 1);
		if(!visited[X - 1]) dfs(sec + 1, X - 1);
		if(!visited[X * 2])	dfs(sec + 1, X * 2);
		
	}
}
