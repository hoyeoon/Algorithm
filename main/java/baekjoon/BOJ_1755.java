package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// 숫자와 영문자를 담는 클래스
class Info {
	int num;
	String word;

	public Info(int num, String word) {
		super();
		this.num = num;
		this.word = word;
	}

	@Override
	public String toString() {
		return "info [num=" + num + ", word=" + word + "]";
	}
}

public class BOJ_1755 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuffer sb = new StringBuffer();
		
		int M = Integer.parseInt(st.nextToken()); 
		int N = Integer.parseInt(st.nextToken());
		
		// 숫자가 들어올 때, 영문자로 바꾸기 위한 배열
		String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		
		// 숫자와 영문자를 함께 갖는 info 클래스를 담는 리스트
		List<Info> info = new ArrayList<>();

		for (int i = M; i <= N; i++) {	// M부터 N까지 반복
			String s = "";
			
			// 십의 자리 숫자일 경우만 진행
			if (i / 10 != 0) {
				s += num[i / 10] + " ";	// 십의 자릿수에 해당하는 숫자의 영문자를 구하여 s에 더함 
			}
			
			s += num[i % 10];	// 일의 자릿수에 해당하는 숫자의 영문자를 구하여 s에 더함
			info.add(new Info(i, s));	// info 리스트에 숫자와 영문자를 함께 넣는다.
		}

		// 영문자를 기준으로 오름차순하여 info를 정렬한다.
		info.sort(new Comparator<Info>() {
			@Override
			public int compare(Info o1, Info o2) {
				return o1.word.compareTo(o2.word);
			};
		});
		
		// 정렬된 info 리스트의 숫자 값을 한 줄에 10개씩 sb에 담는 부분
		int cnt = 1;
		for(Info i : info) {
			sb.append(i.num).append(" ");	// 숫자를 sb에 담는다.
			if(cnt % 10 == 0) sb.append("\n");	// cnt가 10의 배수이면 개행문자를 추가
			cnt++;	// cnt 증가
		}
		System.out.println(sb);
	}
}

