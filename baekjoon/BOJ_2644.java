package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2644 {
	static int n, m, start, end;
	static int[][] map;
	static boolean[] visited;
	static Queue<Integer> q;
	static List<int[]> list;
	static List<Integer> siblings;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		q = new LinkedList<>();
		list = new ArrayList<>();
		siblings = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
//		if(start < end) {
//			int temp = start;
//			start = end;
//			end = temp;
//		}
		
		m = Integer.parseInt(br.readLine());
		
		int parent = 0;
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.add(new int[] {r, c});
			
			if(c == start) {
				parent = r;
			}
		}
		
		System.out.println(parent);
		
		for(int i = 0; i < m; i++) {
			int x = list.get(i)[0];
			int y = list.get(i)[1];
			
			if(x == parent) {
				siblings.add(y);
			}
			
			map[x][y] = 1;
			map[y][x] = 1;
		}
		
		System.out.println(bfs(start));		
	}
	private static int bfs(int start) {
		q.offer(start);
		visited[start] = true;
		int cnt = 1;
		int flag1 = 0;	// 목적지(end)에 도달하는 지 여부를 판단하기 위한 flag
		
		outer : while(!q.isEmpty()) {
			int from = q.poll();
			int flag2 = 0;	// 이동했는지 여부를 판단하기 위한 flag
						
			for(int i = 1; i <= n; i++) {
				if(!visited[i] && map[from][i] == 1) {
					if(i == end) {
						flag1 = 1;
						break outer;
					}
					if(siblings.contains(i)){
						cnt = 0;
					}
					flag2 = 1;
					q.offer(i);
					visited[i] = true;
				}
			}
			if(flag2 == 1) cnt++;
		}
		
		System.out.println(siblings);
		return flag1 == 0 ? -1 : cnt;
	}
}
