package codeup;

import java.io.*;
import java.util.*;

public class codeup_1081 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= a; i++) {
			for(int j = 1; j <= b; j++) {
				System.out.println(i + " " + j);
			}			
		}
	}
}