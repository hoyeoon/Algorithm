package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2021_정답코드 {
	static class Subway {
		int line_num;
		int station_num;
		int transformation_cnt;

		public Subway(int line_num, int station_num, int transformation_cnt) {
			super();
			this.line_num = line_num;
			this.station_num = station_num;
			this.transformation_cnt = transformation_cnt;
		}
	}
	/**
	 * 백준 최소 환승 경로 출발지에서 목적지까지의 최소 환승 경로를 구하자. 환승 회수만 구하면 됨. 환승 가능한 경로를 저장. 
	 * 1번 라인 -> 3번 라인 가능 / 2번 라인 -> 4번 라인 가능 등등 그것이 도착점이 있는 라인에 가장 빨리 도달할 수 있는 값을 구하기.
	 * 
	 * @param args
	 */
	static int N, L;
	static int from, to;
	static int answer = Integer.MAX_VALUE;

	static boolean[] visitedLines;
	static boolean[] visitedStations;

	static List<Integer>[] stations;	// 각 역이 지나는 노선들
	static List<Integer>[] lines; 		// 각 노선이 지나는 역들

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 역의 개수
		L = Integer.parseInt(st.nextToken()); // 노선의 개수

		visitedLines = new boolean[L];
		visitedStations = new boolean[N + 1];
		lines = new ArrayList[L];
		stations = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			stations[i] = new ArrayList<>();
		}
		for (int i = 0; i < L; i++) {
			lines[i] = new ArrayList<>();
		}

		for (int i = 0; i < L; i++) {
			// 각 노선이 지나는 역이 순서대로 주어진다.
			st = new StringTokenizer(br.readLine());
			while (true) {
				int num = Integer.parseInt(st.nextToken());
				if (num == -1)
					break;

				lines[i].add(num);
				stations[num].add(i);
			}
		}

		st = new StringTokenizer(br.readLine());
		from = Integer.parseInt(st.nextToken()); // 출발지
		to = Integer.parseInt(st.nextToken()); // 목적지

		/**
		 * stations[from] 에는 start 역을 지나는 노선들이 담겨 있다. 예시에서는 0라인. lines[0] 0라인이 지나는 역들이
		 * 담겨 있다. 1 2 3 4 5
		 */

		bfs();
		if(answer == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(answer);

	}

	public static void bfs() {
		Queue<Subway> queue = new LinkedList<>();
		visitedStations[from] = true;
		for (int line : stations[from]) {
			queue.offer(new Subway(line, from, 0)); // start 역을 지나는 노선들을 시작
			visitedLines[line] = true;
		}

		while (!queue.isEmpty()) {
			Subway subway = queue.poll();

			if (subway.station_num == to) {
				answer = Math.min(answer, subway.transformation_cnt);
			}

			for (int station : lines[subway.line_num]) { // 해당 라인 지나는 역들
				if (!visitedStations[station]) {
					visitedStations[station] = true;
					queue.offer(new Subway(subway.line_num, station, subway.transformation_cnt));
					for (int line : stations[station]) { // 해당 역을 지나는 노선들
						if (line != subway.line_num && !visitedLines[line]) {
							// 다른 라인을 지나면 환승해보자.
							visitedLines[line] = true;
							queue.offer(new Subway(line, station, subway.transformation_cnt + 1));
						}
					}
				}
			}
		}
	}

}