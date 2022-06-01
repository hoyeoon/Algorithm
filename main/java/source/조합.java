package source;

import java.util.Arrays;

public class 조합 {
	static int[] arr = {1, 2, 3, 4};
	static boolean[] visited = new boolean[4];
	
	static void comb(int start, int n, int r) {
		if(r == 0) {
			System.out.println(Arrays.toString(visited));
			return;
		}
		
		for(int i = start; i < n; i++) {
			visited[i] = true;
			comb(i + 1, n, r - 1);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) {
		comb(0, 4, 2);
	}
}
