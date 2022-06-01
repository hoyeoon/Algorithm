package codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class codeup_1014 {
	public static void main(String[] args) throws IOException {
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		String instr = inbr.readLine();
		
		// 역순을 위해 StringBuffer 클래스의 reverse 메소드 사용
		StringBuffer str = new StringBuffer(instr);
		str.reverse();
		
		System.out.println(str);
	}
}