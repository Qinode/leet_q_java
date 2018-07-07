import java.util.*;

class Solution {
    public void solve(char[][] board) {
        if(board.length == 0){
            return;
        }else{
            int row = board.length;
            int col = board[0].length;
            boolean visited[][] = new boolean[row][col];

            List<int[]> boarderPoints = new ArrayList<int[]>();

            for (int i = 0; i < col; i++){
                boarderPoints.add(new int[] {0, i});
                boarderPoints.add(new int[] {row - 1, i});
            }

            for (int i = 0; i < row; i++){
                boarderPoints.add(new int[] {i, 0});
                boarderPoints.add(new int[] {i, col - 1});
            }

            for (int[] coord : boarderPoints){
                if(!visited[coord[0]][coord[1]] && board[coord[0]][coord[1]] == 'O'){
                    dfs(coord[0], coord[1], board, visited);
                }
            }

            for (int i = 0; i < row; i++){
                for (int j = 0; j< col; j++){
                    if(board[i][j] == 'T'){
                        board[i][j] = 'O';
                    }else if(board[i][j] == 'O'){
                        board[i][j] = 'X';
                    }else{
                        continue;
                    }
                }
            }
        }
    }

    public void dfs(int row, int col, char[][] board, boolean[][] visited){
        if(!visited[row][col]){
            visited[row][col] = true;
            board[row][col] = 'T';
            List<int []> next = getNext(new int[]{row, col}, board);
            for(int[] c : next){
                dfs(c[0], c[1], board, visited);
            }
        }
    }


    public List<int[]> getNext(int[] coord, char[][] board){
        int row = board.length;
        int col = board[0].length;

        int[][] moves = new int[][]{new int[]{-1, 0}, new int[]{0, 1}, new int[]{0, -1}, new int[]{1, 0}};
        List<int []> nextMoves = new ArrayList<int []>();
        for(int [] move: moves){
            int newX = coord[0] + move[0];
            int newY = coord[1] + move[1];

            if((0 <= newX) && (newX < row) && (0 <= newY) && (newY < col) && (board[newX][newY] == 'O')){
                nextMoves.add(new int[]{newX, newY});
            }
        }
        return nextMoves;
    }
}