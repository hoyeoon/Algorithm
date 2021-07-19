package codeup;

import java.io.*;
import java.util.*;

public class codeup_1023 {
	public static void main(String[] args) throws IOException{
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		String instr = inbr.readLine();
		
		StringTokenizer str = new StringTokenizer(instr, ".");
		System.out.printf("%s\n%s", str.nextToken(), str.nextToken());
	}
}