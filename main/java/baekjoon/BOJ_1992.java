package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1992 {
	static char[][] map;
	static String answer = "";
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		for(int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		divideConquer(n, 0, 0);
		System.out.println(answer);
	}
	
	private static void divideConquer(int n, int r, int c) {
		if(n < 1) return;
		
		char v = checkMap(n, r, c);
		
		if(v == 'X') {
			answer += '(';
			divideConquer(n / 2, r, c);
			divideConquer(n / 2, r, c + n / 2);
			divideConquer(n / 2, r + n / 2, c);
			divideConquer(n / 2, r + n / 2, c + n / 2);
			answer += ')';
		}else {
			answer += v;
		}
	}
	
	private static char checkMap(int n, int r, int c) {
		char start = map[r][c]; 
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[r + i][c + j] != start)
					return 'X';
			}
		}
		return start;
	}
}
