package com.khushi;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Solver extends Sudoku_Base {
    private JButton solve;
    private JButton back;

    //Constructor
    Solver() {
        field_arr = new JTextField[9][9];
        setGUI();
        algorithm_solver();
        newSudoku(solve);
        goBack();
        setTitle("SUDOKU SOLVER", 153, 20, frame);
        JOptionPane.showMessageDialog(frame, "Simply type in you unsolved Sudoku puzzle and watch the magic happen!");
    }

    void algorithm_solver() {

        solve = new JButton("SOLVE");
        solve.setBounds(200, 470, 80, 40);
        solve.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                int[][] value = new int[9][9];
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if ((field_arr[i][j].getText().isEmpty())) {
                            field_arr[i][j].setText("0");
                        }
                        value[i][j] = Integer.parseInt(field_arr[i][j].getText());
                        if (value[i][j] > 9 || value[i][j] < 0)
                            wrong();
                    }
                }
                SUDOKU_ALGORITHM solved = new SUDOKU_ALGORITHM(value);
                if (solved.solve()) {
                    value = solved.getBoard();
                    for (int i = 0; i < 9; i++) {
                        for (int j = 0; j < 9; j++) {

                            field_arr[i][j].setText(String.valueOf(value[i][j]));
                        }
                    }
                } else {
                    wrong();
                }
                solve.setEnabled(false);
            }
        });
        frame.add(solve);
    }

    //Method to return the element present in particular box if not return 0
    int get_element(int i, int j) {
        String txt = field_arr[i][j].getText();
        if (txt.isEmpty())
            return 0;
        return Integer.parseInt(txt.trim());
    }
    void goBack(){
        back = new JButton("Back");
        back.setBounds(380, 15, 80, 40);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Home();
                frame.dispose();
            }
        });
        frame.add(back);
    }
    void set_element(int i, int j, int val) {
        field_arr[i][j].setText(String.valueOf(val));
    }

}

