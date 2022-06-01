package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2021 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		boolean[] visited = new boolean[N];
		Queue<Integer> q = new LinkedList<>();
		int minTransferCnt = 0;
		
		while(L-- > 0) {
			int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for(int i = 0; i < s.length - 2; i++) {
				map[s[i] - 1][s[i + 1] - 1] = map[s[i + 1] - 1][s[i] - 1] = 1;
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken()) - 1;
		int end = Integer.parseInt(st.nextToken()) - 1;
		
		visited[start] = true;
		q.offer(start);
		
		while(!q.isEmpty()) {
			int width = 0;
			int x = q.poll();
			
			for(int y = 0; y < N; y++) {
				if(!visited[y] && map[x][y] == 1) {
					if(y == end) {
						if(width > 0) minTransferCnt++;
						break;
					}
					visited[y] = true;
					q.offer(y);
					width++;
				}
			}
			if(width > 1) minTransferCnt++;
		}
		System.out.println(minTransferCnt);
	}
}
