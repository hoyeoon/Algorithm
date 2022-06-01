package codeup;

import java.io.*;
import java.util.*;

public class codeup_1088 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= n; i++) {
			if(i % 3 != 0)
				bw.write(i + " ");
		}
		bw.flush();
	}
}