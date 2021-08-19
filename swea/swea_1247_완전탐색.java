package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1247_완전탐색 {
	static int N;
	static boolean[] isSelected;
	static int[] output;
	static int[][] loc;
	static int minDist;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			
			N = Integer.parseInt(br.readLine());
			isSelected = new boolean[N];
			output = new int[N + 2];
			output[N + 1] = N + 1;
			minDist = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine(), " ");
			
			loc = new int[N + 2][2];
			loc[0] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			loc[N + 1] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			
			for(int i = 1; i <= N; i++) {
				loc[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			}
			perm(0);
			sb.append(minDist).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void perm(int cnt) {
		if(cnt == N) {
//			System.out.println(Arrays.toString(output));
			int dist = 0;

			// 거리계산
			for(int i = 0; i < N + 1; i++) {
				dist += calDist(loc[output[i]], loc[output[i + 1]]);
			}
			
			minDist = Math.min(minDist, dist);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			
			output[cnt + 1] = i + 1;
			isSelected[i] = true;
			
			perm(cnt + 1);
			isSelected[i] = false;
		}
	}
	
	private static int calDist(int[] loc1, int[] loc2) {
		return Math.abs(loc1[0] - loc2[0]) + Math.abs(loc1[1] - loc2[1]);
	}
}
