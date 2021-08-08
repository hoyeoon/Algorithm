package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9935_메모리초과 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = br.readLine();
		String bombStr = br.readLine();
		String[] input;
		
		while(true) {
			input = inputStr.split(bombStr);
			inputStr = String.join("", input);
			
			if(!inputStr.contains(bombStr))
				break;
		}
		if(inputStr.isEmpty())
			System.out.println("FRULA");
		System.out.println(inputStr);		
	}
}
