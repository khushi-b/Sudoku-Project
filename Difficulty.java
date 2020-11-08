package com.khushi;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Difficulty extends Base {
    private JButton easy;
    private JButton med;
    private JButton hard;
    private JButton back;
    private JFrame frame;

    Difficulty() {
        setFrame();goBack(); setTitle("Difficulty", 195,200, frame);
    }

    void setFrame() {
        frame = new JFrame("SUDOKU");
        frame.setSize(480, 600);
        easy = new JButton("Easy");
        easy.setBounds(140, 250, 200, 40);
        easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Generator(26);

            }
        });
        med = new JButton("Medium");
        med.setBounds(140, 300, 200, 40);
        med.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Generator(40);

            }
        });
        hard = new JButton("Hard");
        hard.setBounds(140, 350, 200, 40);
        hard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Generator(48);

            }
        });
        center(frame);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(easy);
        frame.add(med);
        frame.add(hard);
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
}
