package codeup;

import java.io.*;
import java.util.*;

public class codeup_1082 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken(), 16);
		
		for(int i = 1; i < 16; i++) {
			System.out.printf("%X*%X=%X\n", n, i, n * i);
		}
	}
}