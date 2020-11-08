package com.khushi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sudoku_Base extends Base {
    protected JFrame frame;
    protected JTextField[][] field_arr = new JTextField[9][9];
    protected JButton redo;

    protected void setGUI() {
        Color[] col = {Color.white, Color.LIGHT_GRAY, Color.white, Color.LIGHT_GRAY, Color.white, Color.LIGHT_GRAY,
                Color.white, Color.LIGHT_GRAY, Color.white};
        frame = new JFrame("SUDOKU");  //Creating frame
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                field_arr[i][j] = new JTextField();
                field_arr[i][j].setBounds(50 + j * 40, 80 + i * 40, 48, 48);      //Positioning each textfield
                field_arr[i][j].setBackground(col[(i / 3) * 3 + (j / 3)]);        //Setting colour to block from array
                Font font1 = new Font("Trench Thin", Font.PLAIN, 20);        //Setting font to each textfield
                field_arr[i][j].setFont(font1);
                field_arr[i][j].setHorizontalAlignment(SwingConstants.CENTER);    //Setting alignment of text in textfield
                frame.add(field_arr[i][j]);                      //adding textfield to frame
            }
            //Setting the size of frame
            frame.setSize(480, 600);
            center(frame);
            frame.setLayout(null);
            frame.setResizable(false);
            frame.setVisible(true);
        }
    }

    void newSudoku(JButton button) {
        redo = new JButton("Clear");
        redo.setBounds(340, 470, 80, 40);
        redo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear(field_arr);
                button.setEnabled(true);
            }
        });
        frame.add(redo);
    }

    void clear(JTextField[][] field_arr) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                field_arr[i][j].setText("");
            }
        }
    }
    void wrong() {
        JOptionPane.showMessageDialog(frame, "unsolvable");
        clear(field_arr);
    }
}

