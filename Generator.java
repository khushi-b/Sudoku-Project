package com.khushi;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Generator extends Sudoku_Base {
    private JButton generate;
    private JButton check;
    private JButton hint;
    private JButton back;
    private  int k;
    private int[][] value = new int[9][9];
    private int[][] arr = new int[9][9];
    private String level;
    Generator(int x) {
        k = x;
        setGUI();
        algorithm_generator();
        newSudoku(generate);
        check();
        hint();
        goBack();
        setTitle("Difficulty: "+
                getLevel() , 45, 20, frame);
    }
    String getLevel() {
        if (k == 26) {
            level = "Easy";
        }
        if (k == 40) {
            level = "Medium";
        }
        if (k == 48) {
            level = "Hard";
        }
        return level;
    }
    void algorithm_generator() {
        generate = new JButton("New Puzzle");
        generate.setBounds(50, 470, 90, 40);
        generate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SUDOKU_GENERATOR sudoku = new SUDOKU_GENERATOR(k);
                arr = sudoku.getBoard();
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if (!(arr[i][j] == 0))
                            field_arr[i][j].setText(String.valueOf(arr[i][j]));
                    }
                }
                generate.setEnabled(false);
            }
        });
        frame.add(generate);
    }

    void check() {
        check = new JButton("Check");
        check.setBounds(243, 470, 90, 40);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SUDOKU_ALGORITHM solved = new SUDOKU_ALGORITHM(arr);
                int right = 0;
                int wrong = 0;
                getSolvedBoard();
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if (value[i][j] == arr[i][j])
                            right++;
                        else
                            wrong++;
                        if (Integer.parseInt(field_arr[i][j].getText()) == 0)
                            field_arr[i][j].setText("");
                    }
                }
                if (right == 81)
                    JOptionPane.showMessageDialog(frame, "Correct!");
                else
                    JOptionPane.showMessageDialog(frame, "You have " + wrong + " numbers incorrect");


            }
        });
        frame.add(check);
    }

    void hint() {
        hint = new JButton("Hint");
        hint.setBounds(147, 470, 90, 40);
        hint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getSolvedBoard();
                int k = 1;
                while (k != 0) {
                    int row = (int) (Math.random() * 9);
                    int col = (int) (Math.random() * 9);
                    if (arr[row][col] == 0) {
                        field_arr[row][col].setText(String.valueOf(value[row][col]));
                        arr[row][col] = value[row][col];
                        break;
                    } else
                        k++;
                    if (k == 82) {
                        JOptionPane.showMessageDialog(frame, "You have completed the board!");
                        break;
                    }

                }
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if (Integer.parseInt(field_arr[i][j].getText()) == 0)
                            field_arr[i][j].setText("");
                    }
                }

            }

        });
        frame.add(hint);
    }
    void goBack(){
        back = new JButton("Back");
        back.setBounds(380, 15, 80, 40);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Difficulty();
                frame.dispose();
            }
        });
        frame.add(back);
    }

    void getSolvedBoard() {
        SUDOKU_ALGORITHM solved = new SUDOKU_ALGORITHM(arr);
        if (solved.solve()) {
            value = solved.getBoard();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (field_arr[i][j].getText().isEmpty())
                    field_arr[i][j].setText("0");
                arr[i][j] = Integer.parseInt(field_arr[i][j].getText());
            }
        }
    }
}

