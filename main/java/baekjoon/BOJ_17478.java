package baekjoon;

import java.util.Scanner;

public class BOJ_17478 {
	private static String underBar = "";
	private static String[] arr;
	private static void recursive(int i) {
		String tempUnderBar = underBar;
		
		if(i == 0) { 
			System.out.println(underBar + arr[1]);
			System.out.println(underBar + arr[5]);
			System.out.println(underBar + arr[6]);
			return; 
		}
		System.out.println(underBar + arr[1]);
		System.out.println(underBar + arr[2]);
		System.out.println(underBar + arr[3]);
		System.out.println(underBar + arr[4]);
		
		underBar += "____";
		recursive(i - 1);
		
		System.out.println(tempUnderBar + arr[6]);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		arr = new String[7];
		arr[0] = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
		arr[1] = "\"재귀함수가 뭔가요?\"";
		arr[2] = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
		arr[3] = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
		arr[4] = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
		arr[5] = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
		arr[6] = "라고 답변하였지.";
		
		System.out.println(arr[0]);
		recursive(n);
	}
}