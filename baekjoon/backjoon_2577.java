package baekjoon;

import java.util.Scanner;

public class backjoon_2577 {
	public static void main(String[] args) {
		int target = 1;
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 3; i++)
		    target *= sc.nextInt();
		
		int[] answer = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; 
		
		String str = Integer.toString(target);
		System.out.println(str);
		
		for(int i = 0; i < str.length(); i++) {
			answer[str.charAt(i) - '0'] += 1;
		}
		
		for(int i = 0; i < answer.length; i++)
			System.out.println(answer[i]);
	}
}