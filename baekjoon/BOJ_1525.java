package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Info {
	int[][] map;
	boolean[][] visited;
	int cnt;
	int x;
	int y;
	public Info(int[][] map, boolean[][] visited, int cnt, int x, int y) {
		super();
		this.map = map;
		this.visited = visited;
		this.cnt = cnt;
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "Info [map=" + Arrays.deepToString(map) + ", visited=" + Arrays.deepToString(visited) + ", cnt=" + cnt + ", x="
				+ x + ", y=" + y + "]";
	}
}

public class BOJ_1525 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int minMoveCnt = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[][] visited;
	static int x, y;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[3][3];
		visited = new boolean[3][3];
		x = 0;
		y = 0;
		
		for(int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
			map[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(map[i][j] == 0) {
					x = i;
					y = j;
					break;
				}
			}
		}
		System.out.println(x + ", " + y);
		System.out.println(Arrays.deepToString(map));
		System.out.println(bfs());
		System.out.println(Arrays.deepToString(map));
	}
	
	private static int bfs() {
		Queue<Info> q = new LinkedList<>();
		q.offer(new Info(map, visited, 0, x, y));
		visited[x][y] = true;
		int answer = -1;
		
		outer : while(!q.isEmpty()) {
			Info i = q.poll();
			int[][] map = i.map;
			boolean[][] visited = i.visited;
			int cnt = i.cnt;
			int x = i.x;
			int y = i.y;
			
			for(int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(nx < 0 || nx >= 3 || ny < 0 || ny >= 3) continue;
				
				if(!visited[nx][ny]) {
					System.out.println(Arrays.deepToString(map));	// ? 의문
					System.out.println("x, y : " + x + ", " + y);
					System.out.println(nx + ", " + ny);
					if(mapCheck(map)) {
						answer = cnt;
						break outer;
					}
//					System.out.println("0" + Arrays.deepToString(map));
					int temp = map[nx][ny];
					map[nx][ny] = map[x][y];
					map[x][y] = temp;
					visited[nx][ny] = true;
					
					Info a = new Info(map, visited, cnt + 1, nx, ny);
					q.offer(a);
					System.out.println(a);
					
					map[x][y] = 0;
					map[nx][ny] = temp;
//					visited[nx][ny] = false;
				}	
			}
			System.out.println("------------------------------");
		}
		return answer;
	}
	
	// map의 상태가 [[1, 2, 3], [4, 5, 6], [7, 8, 0]]인지 체크 
	private static boolean mapCheck(int[][] map) {
		int num = 1;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(map[i][j] != num) break;
				num++;
			}
		}
		return num == 9 ? true : false;
	}
}