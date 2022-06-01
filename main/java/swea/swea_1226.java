package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class swea_1226 {
	static char[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static Queue<int[]> queue;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {
			sb.append("#").append(t).append(" ");
			br.readLine();
			
			map = new char[16][];
			for(int i = 0; i < 16; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			queue = new LinkedList<>();
			queue.offer(new int[]{1, 1});
			
			int answer = 0;
			outer : while(!queue.isEmpty()) {
				int[] curLoc = queue.poll();
				int curX = curLoc[0];
				int curY = curLoc[1];
				
				for(int i = 0; i < 4; i++) {
					int nx = curX + dx[i];
					int ny = curY + dy[i];
					
					if(nx < 0 || nx >= 16 || ny < 0 || ny >= 16 || map[nx][ny] == '1') {
						continue;
					}
					
					if(map[nx][ny] == '0') {
						map[nx][ny] = '1';
						queue.offer(new int[] {nx, ny});
					}
					
					if(map[nx][ny] == '3') {
						answer = 1;
						break outer;
					}	
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
