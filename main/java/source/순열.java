package source;

import java.util.Arrays;

public class 순열 {
	static int input[] = {1, 2, 3, 4};
	static int output[] = new int[4];
	static boolean[] visited = new boolean[4];

	static void perm(int depth, int n, int r) {
		if(depth == r) {
			System.out.println(Arrays.toString(output));
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				output[depth] = input[i];
				perm(depth + 1, n, r);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		perm(0, 4, 2);
	}
}
