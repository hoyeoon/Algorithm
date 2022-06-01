package codeup;

import java.io.*;
import java.util.*;

public class codeup_1095 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		br.readLine();
		String[] strs = br.readLine().split(" ");
		
		// int[] nums = Arrays.asList(strs).stream().mapToInt(Integer::parseInt).toArray();
		int[] nums = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
		
		int min = Arrays.stream(nums).min().getAsInt();
		
		System.out.println(min);
	}
}