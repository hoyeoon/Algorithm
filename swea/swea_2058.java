package swea;

import java.io.*;

public class swea_2058 {
	public static void main(String[] args) throws IOException {
		BufferedReader brin = new BufferedReader(new InputStreamReader(System.in));
		String strin = brin.readLine();
		int result = 0;
		
		String[] strArray = strin.split("");
		for(String str : strArray) {
			result += Integer.parseInt(str);
		}
		
		System.out.println(result);
	}
}
