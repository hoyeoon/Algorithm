package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1974 {
	static int answer;
	static int[] test;
	static int[][] map = new int[9][9];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			
			for(int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < 9; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
//			answer = testRow(map) & testCol(map) & testSmallMap(map); // 이렇게하면 무조건 3개 전부 계산해야 하므로 안좋다.
			if(testRow(map) == 0 || testCol(map) == 0 || testSmallMap(map) == 0) {
				sb.append(0).append("\n");
				continue;
			}
			sb.append(1).append("\n");
		}
		System.out.println(sb);
	}
	
	static int testArr(int test[]) {
		int flag = 1;
		for(int i = 0; i < test.length; i++) {
			if(test[i] != 1) {
				flag = 0;
				break;
			}
		}
		return flag;
	}
	
	static int testRow(int arr[][]) {
		int answer = 1;
		for(int i = 0; i < arr.length; i++) {
			test = new int[arr.length];
			for(int j = 0; j < arr.length; j++) {
				test[arr[j][i] - 1] = 1;
			}
			if(testArr(test) == 0) {
				answer = 0;
				break;
			}
		}
		return answer;
	}
	
	static int testCol(int arr[][]) {
		int answer = 1;
		for(int i = 0; i < arr.length; i++) {
			test = new int[arr.length];
			for(int j = 0; j < arr.length; j++) {
				test[arr[i][j] - 1] = 1;
			}
			if(testArr(test) == 0) {
				answer = 0;
				break;
			}
		}
		return answer;
	}
	
	static int testSmallMap(int arr[][]) {
		int answer = 1;
		outer : for(int x = 0; x < 3; x++) {
			for(int y = 0; y < 3; y++) {
				test = new int[arr.length];
				for(int i = x * 3; i < x * 3 + 3; i++) {
					for(int j = y * 3; j < y * 3 + 3; j++) {
						test[arr[i][j] - 1] = 1;
					}
				}
				if(testArr(test) == 0) {
					answer = 0;
					break outer;
				}
			}
		}
		return answer;
	}
}
