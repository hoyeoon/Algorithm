package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15683 {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static List<int[]> cctv;
	static int[][] map;
	static int N, M;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cctv = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				int v = Integer.parseInt(st.nextToken());
				map[i][j] = v;
				if(v == 1 || v == 2 || v == 3 || v == 4 || v == 5)
					cctv.add(new int[]{i, j});
			}
		}
		System.out.println(cctv);
		System.out.println(Arrays.deepToString(map));
		
		recursive(0, map);
		System.out.println(answer);
	}
	
	private static void recursive(int cnt, int[][] map) {
		if(cnt == cctv.size()) {
			answer = Math.min(answer, count0(map));
			return;
		}
		int x = cctv.get(cnt)[0];
		int y = cctv.get(cnt)[1];
		int v = map[x][y];
		int n = 0;
		switch(v) {
			case 1: case 3: case 4:
				n = 4;
				break;
			case 2:
				n = 2;
				break;
			case 5:
				n = 1;
				break;
		}
		for(int i = 0; i < n; i++) {
			switch(v) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			}
			recursive(cnt + 1, map);
		}
		
	}
	
	private static int count0(int map[][]) {
		int cnt = 0;
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				if(map[i][j] == 0) cnt++;
			}
		}
		return cnt;
	}
}
