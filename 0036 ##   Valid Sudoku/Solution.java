/*
36. Valid Sudoku

Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 
Example 1:

Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
Example 2:

Input: board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.

Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit 1-9 or '.'.
*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = j + 1; k < 9; k++) {
                    if (board[i][j] != '.' && board[i][j] == board[i][k]) {
                        return false;
                    }
                }
                for (int k = j + 1; k < 9; k++) {
                    if (board[j][i] != '.' && board[j][i] == board[k][i]) {
                        return false;
                    }
                }
            }
        }
        for (int box = 0; box < 9; box++) {
            int rowStart = 3 * (box / 3);
            int colStart = 3 * (box % 3);

            for (int r1 = 0; r1 < 3; r1++) {
                for (int c1 = 0; c1 < 3; c1++) {
                    char ch1 = board[rowStart + r1][colStart + c1];
                    if (ch1 == '.') continue;
                    for (int r2 = r1; r2 < 3; r2++) {
                        for (int c2 = (r2 == r1 ? c1 + 1 : 0); c2 < 3; c2++) {
                            char ch2 = board[rowStart + r2][colStart + c2];
                            if (ch2 != '.' && ch1 == ch2) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        
        return true;
    }
}
