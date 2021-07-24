package codeup;

import java.io.*;
import java.util.*;

public class codeup_1084 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < a; i++) {
			for(int j = 0; j < b; j++) {
				for(int k = 0; k < c; k++) {
					bw.write(i + " " + j + " " + k + "\n");
				}
			}
		}
		bw.write(String.valueOf(a*b*c));
		bw.flush();
	}
}