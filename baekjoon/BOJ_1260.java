package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260 {
	public static void main(String[] args) throws Exception{
		List<List<Integer>> graph = new ArrayList<>();
		boolean[] visited;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N + 1; i++) {
			List<Integer> list = new ArrayList<>();
			graph.add(list);
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph.get(from).add(to);
			graph.get(to).add(from);
		}
		System.out.println(graph);
		
		for(int i = 0; i < graph.size(); i++) {
			Collections.sort(graph.get(i));
		}
		
		System.out.println(graph);
		
		visited = new boolean[N + 1];
		dfs(graph, V, visited);
		System.out.println();
		visited = new boolean[N + 1];
		bfs(graph, V, visited);
	}
	
	static void dfs(List<List<Integer>> graph, int v, boolean[] visited) {
		visited[v] = true;
		System.out.print(v + " ");
		for(int i : graph.get(v)) {
			if(visited[i] == false) {
				dfs(graph, i, visited);
			}
		}
	}
	
	static void bfs(List<List<Integer>> graph, int start, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int v = queue.poll();
			System.out.print(v + " ");
			
			for(int i : graph.get(v)) {
				if(visited[i] == false) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}
