package swea;

import java.io.*;
import java.util.*;

public class swea_1938 {
	public static void main(String[] args) throws Exception {
		BufferedReader brin = new BufferedReader(new InputStreamReader(System.in));
		String strin = brin.readLine();
		
		StringTokenizer str = new StringTokenizer(strin, " ");
		int a = Integer.parseInt(str.nextToken());
		int b = Integer.parseInt(str.nextToken());
		
		System.out.printf("%d\n%d\n%d\n%d",a + b, a - b, a * b, a / b);
	}
}
