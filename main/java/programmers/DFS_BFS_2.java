package programmers;

import java.util.*;

// 네트워크
public class DFS_BFS_2 {
	 public static int solution(int n, int[][] computers) {
	        int answer = 0;
	        boolean[] visited = new boolean[n];
			
			Queue<Integer> q = new LinkedList<>();
			q.offer(0);
			visited[0] = true;
	        
			// bfs 로 한 구역 뽑아내기
			while(!q.isEmpty()) {
				int v = q.poll();
				
				for(int i = 1; i < n; i++) {
					if(visited[i] == false && computers[v][i] == 1) {
						q.offer(i);
						visited[i] = true;
					}
				}
	            System.out.println(q);
				if(q.isEmpty()) {
					// 같은 구역 검사가 끝나면 네트워크 구역 추가
					answer++;
					for(int j = 1; j < n; j++) {
						if(visited[j] == false) {
							// 검사를 못한 구역(있으면) 부터 다시 시작
							q.offer(j);
							break;
						}
					}
				}
			}
			return answer;
	   }
	 public static void main(String[] args) {
		System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
		System.out.println("----------------");
		System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
	}
}
