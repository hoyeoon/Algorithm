package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1062 {
    static List<Character> learnedChar;
    static int maxWordCount;
    static List<String> words;
    static char[] alphas = {'b', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'o', 'p', 'q', 'r', 's', 'u', 'v', 'w', 'x', 'y', 'z'};
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        words = new ArrayList<>();
        visited = new boolean[alphas.length];
        maxWordCount = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            words.add(input.substring(4, input.length() - 4));
        }
        System.out.println("words = " + words);

        getMaxWordCount(n, k);

        System.out.println(maxWordCount);
    }

    private static void getMaxWordCount(int n, int k) {
        if(k < 5) {
            maxWordCount = 0;
            return;
        }
        learnedChar = new ArrayList<>();
        learnedChar.add('a');
        learnedChar.add('c');
        learnedChar.add('i');
        learnedChar.add('n');
        learnedChar.add('t');
        k -= 5;

        comb(0, alphas.length, k);
    }

    private static void comb(int start, int n, int k) {
        if(k == 0) {
            int wordCount = 0;

            outer : for(String word : words) {
                for(int j = 0; j < word.length(); j++) {
                    if(!learnedChar.contains(word.charAt(j))){
                        continue outer;
                    }
                }
                wordCount++;
            }
            maxWordCount = Math.max(maxWordCount, wordCount);
            return;
        }

        for(int i = start; i < n; i++) {
            visited[i] = true;
            learnedChar.add(alphas[i]);
            comb(i + 1, n, k - 1);
            visited[i] = false;
            learnedChar.remove(Character.valueOf(alphas[i]));
        }
    }
}
