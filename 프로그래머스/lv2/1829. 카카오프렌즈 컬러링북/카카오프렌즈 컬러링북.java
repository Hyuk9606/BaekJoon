import java.util.*;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[][] temp = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                temp[i][j] = picture[i][j];
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(temp[i][j] > 0){
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(i,j,temp));
                    numberOfArea++;
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
        
    public class Position{
        int r,c;
        
        Position(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    
    public int bfs(int r, int c, int[][] picture){
        int[][] deltas = {{1,0},{0,1},{0,-1},{-1,0}};
        int color = picture[r][c], count = 1, m = picture.length, n = picture[0].length;
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(r, c));
        picture[r][c] = 0;
        // System.out.println(m + " " + n);
        while(!queue.isEmpty()){
            Position temp = queue.poll();
            
            for(int i=0; i<4; i++){
                int nr = temp.r + deltas[i][0];
                int nc = temp.c + deltas[i][1];
                
                if(nr < 0 || nc < 0 || nr >= m || nc >= n)
                    continue;
                
                if(picture[nr][nc] == color){
                    queue.offer(new Position(nr, nc));
                    picture[nr][nc] = 0;
                    count++;
                }
            }
            
        }
        return count;
        
    }

}