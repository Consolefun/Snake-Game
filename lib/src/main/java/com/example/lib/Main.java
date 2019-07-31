package com.example.lib;

import java.awt.Color;

import javax.swing.JFrame;

// set boundaries and background outside the game board
public class Main {
    public static void main(String[] arg){
        JFrame obj = new JFrame();
        SnakeGame snakeGame = new SnakeGame();
        obj.setBounds(10,10,1018,860);
        obj.setBackground(Color.CYAN);
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(snakeGame);

    }
}
