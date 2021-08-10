package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class swea_1220 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src\\swea\\input_swea_1220.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[][] map;
		
		for (int t = 1; t <= 10; t++) {
			sb.append("#").append(t).append(" ");
			br.readLine();
			map = new char[100][100];
			for(int i = 0; i < 100; i++) {
				map[i] = br.readLine().replace(" ", "").toCharArray();
			}
			int deadLock = 0;
			
			for(int j = 0; j < 100; j++) {
				int nCnt = 0;
				int sCnt = 0;
				for(int i = 0; i < 100; i++) {
					if(map[i][j] == '1') {
						if(nCnt == 0) {
							nCnt++;
							continue;
						}
						if(nCnt == sCnt)
							nCnt++;
					}
					if(map[i][j] == '2') {
						if(nCnt == sCnt + 1) sCnt++;
					}
				}
				deadLock += Math.min(nCnt, sCnt);
			}
			sb.append(deadLock).append("\n");
		}
		System.out.println(sb);
	}
}
