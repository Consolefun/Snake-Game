package com.example.lib;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SnakeGame extends JPanel   implements KeyListener, ActionListener {

    private ImageIcon titleImage;
    private int[] snakexlength = new int[750];
    private int[] snakeylength = new int[750];

    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;

    private ImageIcon righthead;
    private ImageIcon lefthead;
    private ImageIcon uphead;
    private ImageIcon downhead;

    private int lengthofsnake = 3;
    private Timer timer;
    private int delay = 100;

    private ImageIcon snakebody;

    private int moves = 0;

    public SnakeGame(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);

        timer.start();
    }

    public void paint(Graphics g){

        if(moves == 0){
            snakexlength[2] = 50;
            snakexlength[1] = 75;
            snakexlength[0] = 100;

            snakeylength[2] = 200;
            snakeylength[1] = 200;
            snakeylength[0] = 200;
        }

        //draw title image border
        g.setColor(Color.BLACK);
        g.drawRect(24,10, 960, 138);

        // draw the title image
        titleImage = new ImageIcon("C:\\Users\\Kent\\AndroidStudioProjects\\Snake_Game\\lib\\title3.png");
        titleImage.paintIcon(this, g, 25, 11);

        //draw border for SnakeGame
        g.setColor(Color.DARK_GRAY);
        g.drawRect(24, 154, 961, 655);

        // draw background for SnakeGame
        g.setColor(Color.BLUE);
        g.fillRect(25,155,960,657);

        righthead = new ImageIcon("C:\\Users\\Kent\\AndroidStudioProjects\\Snake_Game\\lib\\right_head_update.png");
        righthead.paintIcon(this, g ,snakexlength[0] , snakeylength[0]);

        for(int a = 0; a < lengthofsnake; a++){
            if(a==0 && right){
                righthead = new ImageIcon("C:\\Users\\Kent\\AndroidStudioProjects\\Snake_Game\\lib\\right_head_update.png");
                righthead.paintIcon(this, g ,snakexlength[a] , snakeylength[a]);

            }
            if(a==0 && left){
                lefthead = new ImageIcon("C:\\Users\\Kent\\AndroidStudioProjects\\Snake_Game\\lib\\left_head_update.png");
                lefthead.paintIcon(this, g ,snakexlength[a] , snakeylength[a]);

            }
            if(a==0 && up){
                uphead = new ImageIcon("C:\\Users\\Kent\\AndroidStudioProjects\\Snake_Game\\lib\\up_head_update.png");
                uphead.paintIcon(this, g ,snakexlength[a] , snakeylength[a]);

            }
            if(a==0 && down){
                downhead = new ImageIcon("C:\\Users\\Kent\\AndroidStudioProjects\\Snake_Game\\lib\\down_head_update.png");
                downhead.paintIcon(this, g ,snakexlength[a] , snakeylength[a]);

            }

            if(a!=0){
                snakebody = new ImageIcon("C:\\Users\\Kent\\AndroidStudioProjects\\Snake_Game\\lib\\snake_body_update.png");
                snakebody.paintIcon(this, g ,snakexlength[a] , snakeylength[a]);

            }

        }


        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
