package programmers;

// 여행 경로
import java.util.*;

class DFS_BFS_4 {
    public String[] solution(String[][] tickets) {
        // System.out.println(Arrays.deepToString(tickets));
        Arrays.sort(tickets, new Comparator<String[]>(){
            @Override
            public int compare(String[] o1, String[] o2){
                if(o1[0].toString().contentEquals(o2[0].toString()))
                    return o1[1].toString().compareTo(o2[1].toString());
                else
                    return o1[0].toString().compareTo(o2[0].toString());
            }
        });
        // System.out.println(Arrays.deepToString(tickets));
        
        int N = tickets.length;
        String[] answer = new String[N + 1];
        int idx = 0;
        Queue<String[]> q = new LinkedList<>();
        boolean[] visited = new boolean[N];
        
        for(int i = 0; i < N; i++){
            if(tickets[i][0].equals("ICN")){
                q.offer(new String[]{tickets[i][0], tickets[i][1]});
                answer[idx++] = tickets[i][0];
                answer[idx++] = tickets[i][1];
                visited[i] = true;
                break;
            }
        }
        
        while(!q.isEmpty()){
            String[] ticket = q.poll();
            String to = ticket[1];
            
            for(int i = 0; i < N; i++){
                if(!visited[i] && to.equals(tickets[i][0])){
                    q.offer(new String[]{tickets[i][0], tickets[i][1]});
                    answer[idx++] = tickets[i][1];
                    visited[i] = true;
                    break;
                }
            }
        }
        return answer;
    }
}