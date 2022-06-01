package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_15686_부분집합 {
	static int answer;
	static int n, m, countChicken;
	static int[][] map;
	static int[][] chicken;
	static Stack<int[]> temp = new Stack<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		answer = Integer.MAX_VALUE;
		
		// map 입력받기
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 치킨집 세기
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 2)
					countChicken++;
			}
		}
		// 치킨집 idx 담을 배열 초기화
		chicken = new int[countChicken][2]; 
		
		// 치킨집 idx 정보 추가
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 2) {
					chicken[cnt][0] = i;
					chicken[cnt][1] = j;
					cnt++;
				}
			}
		}
		binaryCounting();
		System.out.println(answer);
	}
	
	private static void binaryCounting() {
		for(int i = 0; i < (1 << (countChicken)); i++) {
			for(int j = 0; j < countChicken; j++) {
				if((i & (1 << j)) != 0) {
					temp.push(chicken[j]);					
				}
			}
			// 치킨집의 개수은 최대 m, 최소 1.
			if(temp.size() > m || temp.size() < 1) {
				temp.clear();
				continue;
			} 
			
			int distance = 0;
			for(int x = 0; x < n; x++) {
				for(int y = 0; y < n; y++) {
					int min = Integer.MAX_VALUE;
					if(map[x][y] == 1) {
						for(int s = 0; s < temp.size(); s++) {
							min = Math.min(min, Math.abs(x - temp.get(s)[0]) + Math.abs(y - temp.get(s)[1]));
						}
						distance += min;
					}
				}
			}
			answer = Math.min(answer, distance);
			temp.clear();
		}
	}
}
