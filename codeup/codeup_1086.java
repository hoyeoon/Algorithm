package codeup;

import java.io.*;
import java.util.*;

public class codeup_1086 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		double volume = (double)w * h * b / 8 / 1024 / 1024;
		System.out.printf("%.2f MB", volume);
	}
}