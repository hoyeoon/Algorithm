package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class swea_5215 {
	static int N, L;
	static int[][] input;
	static boolean[] isSelected;
	static Stack<Integer> stack = new Stack<>();;
	static int maxScore;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			input = new int[N][2];
			isSelected = new boolean[N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				input[i][0] = Integer.parseInt(st.nextToken());
				input[i][1] = Integer.parseInt(st.nextToken());
			}
			generateSubset(0);
			
			maxScore = Integer.MIN_VALUE;
			while(!stack.isEmpty()) {
				maxScore = Integer.max(maxScore, stack.pop());
			}
			sb.append(maxScore).append("\n");
		}
		System.out.println(sb);
	}
	
	static void generateSubset(int cnt) {
		if(cnt == N) {
			int sumCal = 0;
			int sumScore = 0;
			for(int i = 0; i < N; i++) {
				if(isSelected[i]) {
					sumScore += input[i][0];
					sumCal += input[i][1];
				}
			}
			if(sumCal <= L)
				stack.push(sumScore);
			
			return;
		}
		
		isSelected[cnt] = true;
		generateSubset(cnt + 1);
		
		isSelected[cnt] = false;
		generateSubset(cnt + 1);
	}
}
