package com.khushi;

public class SUDOKU_ALGORITHM {

    private final int[][] board;


    public SUDOKU_ALGORITHM(int[][] board) {
        this.board = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.board[i][j] = board[i][j];

            }
        }
    }

    public int[][] getBoard() {
        return board;
    }

    public boolean isinRow(int row, int number) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    public boolean isinCol(int col, int number) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == number) {
                return true;
            }
        }
        return false;
    }

    public boolean isinBox(int row, int col, int num) {
        int r = row - row % 3;
        int c = col - col % 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (board[i][j] == num)
                    return true;
            }
        }
        return false;
    }

    public boolean works(int row, int col, int num) {
        return (!isinRow(row, num) && !isinCol(col, num) && !isinBox(row, col, num));
    }

    public boolean solve() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int v = 1; v < 10; v++) {
                        if (works(row, col, v)) {
                            board[row][col] = v;
                            if (solve()) {
                                return true;
                            } else {
                                board[row][col] = 0;
                            }
                        }

                    }
                    return false;
                }
            }

        }
        return true;
    }

    public void display() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(" " + board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

}

