package codeup;

import java.io.*;
import java.util.*;

public class codeup_1092 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int i = 1;
		
		while(true) {
			if(i % a == 0 && i % b == 0 && i % c == 0) {
				System.out.println(i);
				break;
			}
			i++;
		}
	}
}