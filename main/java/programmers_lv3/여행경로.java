package programmers_lv3;
import java.util.*;

public class 여행경로 {
    final String START_AIRPORT = "ICN";
    int n;
    String[][] tickets;
    String[] answer;

    public String[] solution(String[][] tickets) {
        this.n = tickets.length;
        this.tickets = setTickets(tickets);
        answer = new String[n + 1];
        answer[0] = START_AIRPORT;

        bfs();

        return answer;
    }

    private String[][] setTickets(String[][] t){
        String[][] tickets = new String[n + 1][];

        for(int i = 0; i < n; i++){
            tickets[i] = t[i];
        }
        tickets[n] = new String[]{"", ""}; // 더미 데이터

        return tickets;
    }

    private void bfs(){
        Queue<Info2> q = new LinkedList<>();
        q.add(new Info2(START_AIRPORT, 0, new boolean[n + 1], new ArrayList<>()));

        while(!q.isEmpty()){
            Info2 info = q.poll();
            String target = info.getTarget();
            int cnt = info.getCnt();
            boolean[] visited = info.getVisited();
            List<Integer> path = info.getPath();

            if(cnt == n){
                //System.out.println(target + ", " + cnt + ", " + Arrays.toString(visited) + ", " + path);

                if(answer[1] == null){
                    for(int i = 1; i < n + 1; i++){
                        answer[i] = tickets[path.get(i - 1)][1];
                    }
                } else{
                    int flag = 0;
                    for(int i = 1; i < n + 1; i++){
                        //System.out.println(answer[i].compareTo(tickets[path.get(i - 1)][1]));
                        if(answer[i].compareTo(tickets[path.get(i - 1)][1]) > 0) {
                            flag = 1;
                            break;
                        }
                        if(answer[i].compareTo(tickets[path.get(i - 1)][1]) < 0) {
                            break;
                        }
                    }
                    if(flag == 1){
                        for(int j = 1; j < n + 1; j++){
                            answer[j] = tickets[path.get(j - 1)][1];
                        }
                    }
                }
                //System.out.println(Arrays.toString(answer));
                continue;
            }

            for(int i = 0; i < n + 1; i++){
                if(visited[i]) continue;
                if(!tickets[i][0].equals(target)) continue;

                boolean[] newVisited = deepCopyVisited(visited);
                List<Integer> newPath = deepCopyPath(path);
                newVisited[i] = true;
                newPath.add(i);
                q.add(new Info2(tickets[i][1], cnt + 1, newVisited, newPath));
            }
        }
    }

    private boolean[] deepCopyVisited(boolean[] visited){
        int n = visited.length;
        boolean[] newVisited = new boolean[n];

        for(int i = 0; i < n; i++){
            newVisited[i] = visited[i];
        }

        return newVisited;
    }

    private List<Integer> deepCopyPath(List<Integer> path){
        int n = path.size();
        List<Integer> newPath = new ArrayList<>();

        for(int i = 0; i < n; i++){
            newPath.add(path.get(i));
        }

        return newPath;
    }
}

class Info2{
    private String target;
    private int cnt;
    private boolean[] visited;
    private List<Integer> path;

    public Info2(String target, int cnt, boolean[] visited, List<Integer> path){
        this.target = target;
        this.cnt = cnt;
        this.visited = visited;
        this.path = path;
    }

    public String getTarget(){
        return this.target;
    }

    public int getCnt(){
        return this.cnt;
    }

    public boolean[] getVisited(){
        return this.visited;
    }

    public List<Integer> getPath(){
        return this.path;
    }
}
