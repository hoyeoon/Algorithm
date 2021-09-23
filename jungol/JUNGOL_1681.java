package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Info {
	int node;
	int depth;
	int cost;
	boolean[] visited;
	String path;
	
	Info(int node, int depth, int cost, boolean[] visited, String path) {
		super();
		this.node = node;
		this.depth = depth;
		this.cost = cost;
		this.visited = visited;
		this.path = path;
	}

	@Override
	public String toString() {
		return "Info [node=" + node + ", depth=" + depth + ", cost=" + cost + ", visited=" + Arrays.toString(visited)
				+ ", path=" + path + "]";
	}
}

public class JUNGOL_1681 {
	static int N, answer;
	static int[][] map;
	static boolean[] visited;
	static Queue<Info> q;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N];
		answer = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(Arrays.deepToString(map));
		
		bfs();
		System.out.println(answer);
	}
	private static void bfs() {
		q = new LinkedList<>();	// int[]배열은 출발 node, depth, cost 비용이 들어 있음.
		visited[0] = true;
		q.offer(new Info(0, 1, 0, visited, "1"));
		
		while(!q.isEmpty()) {
			Info info = q.poll();
			int node = info.node;
			int depth = info.depth;
			int cost = info.cost;
			boolean[] visited = info.visited;
			String path = info.path;
			
			if(depth == N) {
				System.out.println(info);
				answer = Math.min(answer, cost + map[node][0]);
				continue;
			}
			for(int i = 0; i < N; i++) {
				if(!visited[i] && map[node][i] != 0) {
					visited[i] = true;
					q.offer(new Info(i, depth + 1, cost + map[node][i], visited, path + (i + 1)));
					visited[i] = false;
				}
			}
			System.out.println(q);
		}
	}
}
