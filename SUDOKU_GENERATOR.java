package com.khushi;

public class SUDOKU_GENERATOR {
    private int[][] board = new int[9][9];
    private int k;

    SUDOKU_GENERATOR(int x) {
        k = x;
    }

    public void fillBox(int r, int c) {
        int num;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                SUDOKU_ALGORITHM sudoku = new SUDOKU_ALGORITHM(board);
                do {
                    num = (int) (Math.random() * 9 + 1);
                }
                while (sudoku.isinBox(r, c, num));
                board[r + i][c + j] = num;
            }
        }
    }

    public void fillDiagonal() {
        for (int i = 0; i < 9; i += 3) {
            fillBox(i, i);
        }
    }
    //fills the rest of the box using the sudoku_algorithm class
    public void fill() {
        SUDOKU_ALGORITHM sudoku = new SUDOKU_ALGORITHM(board);
        sudoku.solve();
        board = sudoku.getBoard();
    }
    //Removes k number of boxes to create the game
    public void remove() {
        while (k != 0) {
            int row = (int) (Math.random() * 9);
            int col = (int) (Math.random() * 9);
            if (board[row][col] != 0)
                board[row][col] = 0;
            k--;
        }
    }
    
    public void fillValues()   
        fillDiagonal();
        fill();
        remove();
    }

    public int[][] getBoard() {
        fillValues();
        return board;
    }

}

