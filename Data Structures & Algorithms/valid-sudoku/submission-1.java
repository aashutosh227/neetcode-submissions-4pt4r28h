class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][][] subBoxes = new int[3][3][9];

        for(int i = 0;i<board.length;i++){
            int[] visitedRow = new int[board.length];
            int[] visitedCol = new int[board.length];
            for(int j =0;j<board.length;j++){
                if(Character.isDigit(board[i][j])
                 && (visitedRow[Character.getNumericValue(board[i][j])-1] == 1)){
                    return false;
                }
                else if(Character.isDigit(board[i][j])){
                visitedRow[Character.getNumericValue(board[i][j])-1] = 1;
                }

                if(Character.isDigit(board[j][i])
                && (visitedCol[Character.getNumericValue(board[j][i])-1] == 1)){
                    return false;
                }
                else if(Character.isDigit(board[j][i])){
                visitedCol[Character.getNumericValue(board[j][i])-1] = 1;
                }
            }
        }

        for(int i=0;i<board.length;i++){
            int si = i/3;
            for(int j=0; j<board.length;j++){
                if(!Character.isDigit(board[i][j])){
                    continue;
                }
                int sj = j/3;
                int n = subBoxes[si][sj][Character.getNumericValue(board[i][j])-1];
                if(n==1){
                    return false;
                }
                else{
                    subBoxes[si][sj][Character.getNumericValue(board[i][j])-1] = 1;
                }
            }
        }

        return true;

    }
}
