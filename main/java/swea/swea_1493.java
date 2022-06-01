package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class swea_1493 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int[] loc1 = getLoc(p);
			int[] loc2 = getLoc(q);
			
			int x = loc1[0] + loc2[0];
			int y = loc1[1] + loc2[1];
			
			sb.append(getValue(new int[] {x, y})).append("\n");
		}
		System.out.println(sb);
	}
	
	private static int[] getLoc(int value) {
		int cnt = 0;
		for(int i = 1; ; i++) {
			for(int x = i, y = 1; x >= 1; x--, y++) {
				cnt++;
				if(cnt == value) return new int[] {x, y};
			}
		}
	}
	
	private static int getValue(int[] loc) {
		int value = 0;
		for(int i = 1; ; i++) {
			for(int x = i, y = 1; x >= 1; x--, y++) {
				value++;
				if(loc[0] == x && loc[1] == y) return value;
			}
		}
	}
}
