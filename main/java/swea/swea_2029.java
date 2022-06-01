package swea;

import java.io.*;
import java.util.*;

public class swea_2029 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= n; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			System.out.printf("#%d %d %d\n", i, a / b, a % b);
		}
	}
}
