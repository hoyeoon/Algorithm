package codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class codeup_1020 {
	public static void main(String[] args) throws IOException {
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		String instr = inbr.readLine();
		
		StringTokenizer str = new StringTokenizer(instr, "-");
		
		System.out.printf("%s%s",str.nextToken(),str.nextToken());
	}
}