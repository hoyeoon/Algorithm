package codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class codeup_1015 {
	public static void main(String[] args) throws IOException {
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		String instr = inbr.readLine();
		float f = Float.parseFloat(instr);
		
		System.out.printf("%.2f", f);
	}
}