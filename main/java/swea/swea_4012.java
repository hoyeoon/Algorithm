package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class swea_4012 {
	static int N;
	static int[] input;
	static int[] output;
	static int[][] map;
	static List<int[]> list;
	static List<int[]> idx;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			list = new ArrayList<>();
			idx = new ArrayList<>();
			int answer = Integer.MAX_VALUE;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
//			System.out.println(Arrays.deepToString(map));
			
			input = new int[N];
			for(int i = 0; i < N; i++) {
				input[i] = i; 
			}
			
//			System.out.println(Arrays.toString(input));
			
			output = new int[N / 2];
			combination(0, 0);
			
//			System.out.println(list);
			
			for(int x = 0; x < N / 2; x++) {
				for(int y = x + 1; y < N / 2; y++) {
					idx.add(new int[] {x, y});
					idx.add(new int[] {y, x});
				}
			}
//			System.out.println(idx);
			
			int n = list.size();
			for(int i = 0; i < n / 2; i++) {
//				System.out.println(list.get(i)[0] + ", " + list.get(i)[1]);
//				System.out.println(list.get(i)[1] + ", " + list.get(i)[0]);
				
				int s1 = 0;
				for(int j = 0; j < idx.size(); j++) {
					s1 += map[list.get(i)[idx.get(j)[0]]][list.get(i)[idx.get(j)[1]]];
				}
				int s2 = 0;
				for(int j = 0; j < idx.size(); j++) {
					s2 += map[list.get(n - 1 - i)[idx.get(j)[0]]][list.get(n - 1 - i)[idx.get(j)[1]]];
				}
				answer = Math.min(answer, Math.abs(s1 - s2));
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void combination(int cnt, int start) {
		if(cnt == N / 2) {
			int[] temp = new int[output.length];
			for(int i = 0; i < temp.length; i++) {
				temp[i] = output[i];
			}
			list.add(temp);
			return;
		}
		
		// start 위치의 수부터 가능한 수 모두 고려
		for(int i = start; i < N; i++) {
			output[cnt] = input[i];
			
			// 다음 자리순열 뽑으러 간다.
			combination(cnt + 1, i + 1);
		}
	}
}
