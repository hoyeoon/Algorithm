package swea;

import java.io.*;
import java.util.*;

public class swea_2063 {
	public static void main(String[] args) throws Exception {
		List<Integer> scoreList = new ArrayList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		
		while(st.hasMoreTokens()) {
			scoreList.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(scoreList);
		
		System.out.println(scoreList.get(t / 2));
	}
}
