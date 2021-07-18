package codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class codeup_1017 {
	public static void main(String[] args) throws IOException {
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		String instr = inbr.readLine();
		int num = Integer.parseInt(instr);
		
		for(int i = 0; i < 3; i++)
			System.out.printf("%d ", num);
	}
}