package com.khushi;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends Base {
    private JFrame frame;
    private JButton solve;
    private JButton play;

    Home() {
        setFrame();
        setTitle("Welcome!", 190, 200, frame);
    }

    public static void main(String[] args) {
        new Home();
    }

    void setFrame() {
        frame = new JFrame("SUDOKU");
        frame.setSize(480, 600);
        center(frame);
        solve = new JButton("Solve my Sudoku Puzzle");
        solve.setBounds(140, 310, 200, 40);
        solve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Solver();

            }
        });
        play = new JButton("New Game");
        play.setBounds(140, 260, 200, 40);
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //frame.setVisible(false);
                frame.dispose();
                new Difficulty();

            }
        });
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(solve);
        frame.add(play);

    }
}


