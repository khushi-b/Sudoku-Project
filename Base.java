package com.khushi;

import javax.swing.*;
import java.awt.*;

public class Base {
    private JLabel title;
    protected void center(JFrame frame) {
        //Taking the dimensions of present screen
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dimension.width / 2 - frame.getWidth() / 2, dimension.height / 2 - frame.getHeight() / 2);
        frame.setSize(480, 600);
    }
    void setTitle(String phrase, int x, int y, JFrame frame){
        title =new JLabel(phrase);
        title.setBounds(x, y, 300,40);
        frame.add(title);
        Font font1 = new Font("Trench Thin", Font.PLAIN, 20);
        title.setFont(font1);
    }

}
