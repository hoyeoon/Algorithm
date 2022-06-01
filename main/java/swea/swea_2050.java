package swea;

import java.io.*;

public class swea_2050 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] ch = br.readLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < ch.length; i++)
			sb.append(ch[i] - 64).append(" ");
		
		System.out.println(sb);	
	}
}
