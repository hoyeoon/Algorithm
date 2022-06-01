package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.*;

public class BOJ_17135 {
	static int N, M, D, ans = Integer.MIN_VALUE;
	static int[][] map;
	static int[][] origin_map;
	static int[] archer;
	static Set<int[]> set = new HashSet<>();
	static int enemy = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		archer = new int[3];
		map = new int[N][M];
		origin_map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < map.length; i++) {
	        System.arraycopy(map[i], 0, origin_map[i], 0, map[i].length);
	    }
		System.out.println(Arrays.deepToString(origin_map));
		comb(0, 0);
		System.out.println(enemy);
	}
	
	private static void comb(int cnt, int start) {
		if(cnt == 3) {
			System.out.println(Arrays.toString(archer));
			int enemyCount = 0;
			
			for(int t = 1; t < N; t++) {
				int base = N - t;
				outer : for(int a = 0; a < 3; a++) {
					int stand = archer[a];
					
					for(int i = stand - D; i < stand + D + 1; i++) {
						for(int j = base; j > base - D; j--) {
							if(j < 0 || j >= base + 1 || i < 0 || i >= M)
								continue;
							System.out.print("(" + j + ", " + i + ") ");
							if(map[j][i] == 1) {
								int distance = calcDist(j, i, base + 1, stand);
								if(distance <= D) {
									set.add(new int[] {j, i});
									continue outer;
								}	
							}
							System.out.print("거리 = " + calcDist(j, i, N, stand));
						}
						System.out.println("");
					}
					System.out.println("---------------");
				}
				
				System.out.println("set.size() = " + set.size());
				ans = Math.max(ans, set.size());
				
				List<int[]> list = new ArrayList<>(set);
				set.clear();
				
				for(int i = 0; i < list.size(); i++) {
					map[list.get(i)[0]][list.get(i)[1]] = 0;
				}
				System.out.println("map의모습 : " + Arrays.deepToString(map));
				// map 을 원래 값으로 초기화
				for (int i = 0; i < map.length; i++) {
			        System.arraycopy(origin_map[i], 0, map[i], 0, map[i].length);
			    }
				enemyCount += ans;
			}
			enemy = Math.max(enemyCount, enemy);
			
			
			return;
		}
		for(int i = start; i < M; i++) {
			archer[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}
	
	private static int calcDist(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
}
