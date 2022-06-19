class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows+1][columns+1];
        
        int count = 1;
        for(int r = 1; r <=rows; r++){
            for(int c = 1; c <= columns; c++){
                map[r][c] = count++;        
            }
        }
        count = 0;
        for(int[] query : queries){
            answer[count++] = rotate(map,query);
        }
        
        return answer;
    }
    
    public int rotate(int[][] map, int[] query){
        int temp = map[query[0]][query[1]];
        int min = temp;
        
        for(int r = query[0]+1; r <= query[2]; r++){
            map[r-1][query[1]] = map[r][query[1]];
            min = Math.min(min, map[r][query[1]]);
        }
        
        for(int c = query[1]+1; c <= query[3]; c++){
            map[query[2]][c-1] = map[query[2]][c];
            min = Math.min(min,map[query[2]][c]);
        }
        
        for(int r = query[2]-1; r >= query[0]; r--){
            map[r+1][query[3]] = map[r][query[3]];
            min = Math.min(min, map[r][query[3]]);
        }
        
        for(int c = query[3]-1; c >= query[1]; c--){
            map[query[0]][c+1] = map[query[0]][c];
            min = Math.min(min,map[query[0]][c]);
        }
        
        map[query[0]][query[1]+1] = temp;
        
        return min;
        
    }
}