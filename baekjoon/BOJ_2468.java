package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_2468 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int input[][] = new int[n][n];
		int map[][];
		int dx[] = {-1, 1, 0, 0};
		int dy[] = {0, 0, -1, 1};
		Queue<int[]> q;
		Set<Integer> heights = new HashSet<>();
		int answer = 0;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < n; j++) {
				int v = Integer.parseInt(st.nextToken());
				input[i][j] = v;
				heights.add(v);
			}
		}
		
		for(int height : heights) {
			// map 초기화
			map = new int[n][n];
			
			// height이하의 원소를 1로 하는 map 생성
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(input[i][j] <= height) {
						map[i][j] = 1;
					}
				}
			}
			
			// 물에 잠기지 않는 부분을 세는 변수 cnt 초기화
			int cnt = 0;
			
			// map[0][0]부터 map[n-1][n-1]순회
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					// cnt를 세기 위한 flag 변수 초기화
					int flag = 0;
					
					// BFS
					q = new LinkedList<>();
					q.offer(new int[] {i, j});
					while(!q.isEmpty()) {
						int[] loc = q.poll(); 
						int curX = loc[0];
						int curY = loc[1];
						
						for(int d = 0; d < 4; d++) {
							int nx = curX + dx[d];
							int ny = curY + dy[d];
							
							if(nx < 0 || nx >= n || ny < 0 || ny >= n || map[nx][ny] == 1) {
								continue;
							}				
							if(map[nx][ny] == 0) {
								// 이 부분이 실행된 것은 물에 잠기지 않는 부분이라는 뜻. flag를 1로 설정
								flag = 1;
								map[nx][ny] = 1;
								q.offer(new int[]{nx, ny});
							}
						}
					}
					// flag가 1로 되어있다면 cnt증가
					if(flag == 1) cnt++;
				}
			}
			// 최대 cnt 구하기
			answer = Math.max(answer, cnt);
		}
		
		// 문제 노트 : 아무 지역도 물에 잠기지 않을 수도 있다.
		if(answer == 0) 
			answer = 1;
		System.out.println(answer);
	}
}
