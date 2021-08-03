package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
1 0 0 0 1 0 1 0 0 1
1 0 0 0 1 0 1 1 1 1
1 0 0 0 1 0 1 0 0 1
1 0 0 0 1 1 1 0 0 1
1 0 0 0 1 0 1 0 0 1
1 1 1 1 1 0 1 1 1 1
1 0 0 0 1 0 1 0 0 1
1 1 1 1 1 0 1 0 0 1
1 0 0 0 1 1 1 0 0 1
1 0 0 0 1 0 1 0 0 2
*/
public class swea_1210 {
	static int[] dx = {-1, 0, 0};
	static int[] dy = {0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		char[] temp = br.readLine().replace(" ", "").toCharArray();
		int size = temp.length;
		char[][] map = new char[size][size];
		map[0] = temp;
		int startIdx = 0;
		
		for(int i = 1; i < size; i++) {
			map[i] = br.readLine().replace(" ", "").toCharArray();
		}
		
		for(int i = 0; i < size; i++) {
			if(map[size - 1][i] == '2') {
				startIdx = i;
				break;
			}
		}
		
		int flag = 0; // flag 0은 세로이동 중, 1은 가로이동 중
		// 시작 idx 세팅
		int x = size - 1;
		int y = startIdx;
		
		
		
	}
}
