package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_15686 {
	static List<int[]> home = new ArrayList<>();
	static List<int[]> chickens = new ArrayList<>();
	static int N, M, ans = (int)1e9;
	static int[] sel;
	static int[][] dist; // 치킨집과 집과의 거리를 저장할 배열
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader("5 2\r\n" + 
				"0 2 0 1 0\r\n" + 
				"1 0 1 0 0\r\n" + 
				"0 0 0 0 0\r\n" + 
				"2 0 0 1 1\r\n" + 
				"2 2 0 1 2"));
		String[] data = br.readLine().split(" ");
		N = Integer.parseInt(data[0]);
		M = Integer.parseInt(data[1]);
		
		for(int i = 0; i < N; i++) {
			data = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				int v = Integer.parseInt(data[j]);
				if(v == 1) home.add(new int[] {i, j});// 집
				else if(v == 2) chickens.add(new int[] {i, j});// 치킨집
			}
		}
		
		// 치킨집과 집의 거리를 저장(메모이제이션)
		dist = new int[13][100];
		for(int i = 0; i < chickens.size(); i++) {
			for(int j = 0; j < home.size(); j++) {
				dist[i][j] = calcDist(chickens.get(i), home.get(j));
			}
		}
		
		// 조합 처리
		sel = new int[M];
		comb(0, 0);
		System.out.println(ans);
	}
	
	private static void comb(int cnt, int start) {
		if(cnt == M) {
			// 도시의 치킨거리 구한다.
			int cityDist = 0;
			System.out.println(Arrays.toString(sel));
			System.out.println("-----------------");
			for(int i = 0; i < home.size(); i++) {
				int homeDist = (int)1e9; // 집에서의 치킨 거리
				for(int j = 0; j < M; j++) {
					homeDist = Math.min(homeDist, dist[sel[j]][i]);	// 집의 치킨거리
				}
				cityDist += homeDist;
			}
			// 모든 조합의 치킨거리에서 가장 작은 치킨거리를 구한다.
			ans = Math.min(ans, cityDist);
			return;
		}
		
		for(int i = start; i < chickens.size(); i++) {
			sel[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}

	private static int calcDist(int[] loc1, int[] loc2) {
		return Math.abs(loc1[0] - loc2[0]) + Math.abs(loc1[1] - loc2[1]); 
	}
}
