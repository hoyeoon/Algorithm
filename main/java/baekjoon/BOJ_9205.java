package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205 {
	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		int t = Integer.parseInt(br.readLine());

		while(t-- > 0){
			int n = Integer.parseInt(br.readLine());	// 편의점 수
			st = new StringTokenizer(br.readLine(), " ");

			Point startPoint = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			List<Point> conveinientList = new ArrayList<>();
			for(int i = 0; i < n; i++){
				st = new StringTokenizer(br.readLine(), " ");
				conveinientList.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}

			st = new StringTokenizer(br.readLine(), " ");
			Point endPoint = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			String result = bfs(n, startPoint, conveinientList, endPoint) ? "happy" : "sad";
			sb.append(result).append("\n");
		}
		sb.setLength(sb.length() - 1);
		br.close();

		System.out.println(sb);
	}

	private static boolean bfs(int n, Point startPoint, List<Point> conveinientList, Point endPoint) {

		boolean[] visited = new boolean[n];
		Queue<Point> q = new LinkedList<>();

		q.add(startPoint);

		while(!q.isEmpty()){
			Point point = q.poll();

			if(getDistance(point, endPoint) <= 1000) {
				return true;
			}

			for(int i = 0; i < n; i++) {
				if(!visited[i]) {
					if(getDistance(point, conveinientList.get(i)) <= 1000){
						visited[i] = true;
						q.offer(conveinientList.get(i));
					}
				}
			}
		}

		return false;
	}

	private static int getDistance(Point point1, Point point2) {
		return Math.abs(point1.x - point2.x) + Math.abs(point1.y - point2.y);
	}
}