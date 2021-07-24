package codeup;

import java.io.*;
import java.util.*;

public class codeup_1094 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		br.readLine();
		String[] arr = br.readLine().split(" ");
		
		// Array -> List -> reverse -> Array
		List<String> list = Arrays.asList(arr);
		Collections.reverse(list);
		String[] reverseArr = list.toArray(new String[list.size()]);
		
		for(String i : reverseArr)
			sb.append(i).append(" ");
		System.out.println(sb);
	}
}