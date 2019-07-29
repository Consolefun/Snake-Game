package com.example.lib;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SnakeGame extends JPanel   implements KeyListener, ActionListener {

    private ImageIcon titleImage;
    private int[] snakexlength = new int[850];
    private int[] snakeylength = new int[850];

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
    private int delay = 85;

    private ImageIcon snakebody;
    private int[] applexpos = {25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,
            400,425,450,475,500,525,550,575,600,625,650,675,700,725,750,
            775,800,825,850,875,900,925,950};
    //check the first index [0]->75
    private int[] appleypos = {175,200,225,250,275,300,325,350,375,
            400,425,450,475,500,525,550,575,600,625,650, 675};

    private ImageIcon appleimage;

    private Random random = new Random();

    private int xpos = random.nextInt(38);

    private int ypos = random.nextInt(21);

    private int moves = 0;

    private int score = 0;

    public SnakeGame(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);

        timer.start();
    }

    public void paint(Graphics g){

        // Length of snake at the beginning of the game
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
        g.drawRect(24, 174, 961, 676);

        // draw background for SnakeGame
        g.setColor(Color.BLUE);
        g.fillRect(25,175,960,675);

        // draw score board
        g.setColor(Color.blue);
        g.setFont(new Font("arial", Font.PLAIN, 14));
        g.drawString("Scores: "+ score, 900, 30);

        //Show length of snake
        g.setColor(Color.blue);
        g.setFont(new Font("arial", Font.PLAIN, 14));
        g.drawString("Length: "+ lengthofsnake, 900, 50);

        righthead = new ImageIcon("C:\\Users\\Kent\\AndroidStudioProjects\\Snake_Game\\lib\\right_head_update.png");
        righthead.paintIcon(this, g ,snakexlength[0] , snakeylength[0]);

        appleimage = new ImageIcon("C:\\Users\\Kent\\AndroidStudioProjects\\Snake_Game\\lib\\apple_new_update.png");

        for(int a = 0; a < lengthofsnake; a++){
            if(a==0 && right){
                righthead = new ImageIcon("C:\\Users\\Kent\\AndroidStudioProjects\\Snake_Game\\lib\\right_head_update.png");
                righthead.paintIcon(this, g ,snakexlength[a] , snakeylength[a]);

                if((applexpos[xpos] == snakexlength[a] && appleypos[ypos] == snakeylength[a])){
                    score++;
                    lengthofsnake++;
                    xpos = random.nextInt(38);
                    ypos = random.nextInt(21);
                }

            }
            if(a==0 && left){
                lefthead = new ImageIcon("C:\\Users\\Kent\\AndroidStudioProjects\\Snake_Game\\lib\\left_head_update.png");
                lefthead.paintIcon(this, g ,snakexlength[a] , snakeylength[a]);

                if((applexpos[xpos] == snakexlength[a] && appleypos[ypos] == snakeylength[a])){
                    score++;
                    lengthofsnake++;
                    xpos = random.nextInt(38);
                    ypos = random.nextInt(21);
                }


            }
            if(a==0 && up){
                uphead = new ImageIcon("C:\\Users\\Kent\\AndroidStudioProjects\\Snake_Game\\lib\\up_head_update.png");
                uphead.paintIcon(this, g ,snakexlength[a] , snakeylength[a]);

                if((applexpos[xpos] == snakexlength[a] && appleypos[ypos] == snakeylength[a])){
                    score++;
                    lengthofsnake++;
                    xpos = random.nextInt(38);
                    ypos = random.nextInt(21);
                }


            }
            if(a==0 && down){
                downhead = new ImageIcon("C:\\Users\\Kent\\AndroidStudioProjects\\Snake_Game\\lib\\down_head_update.png");
                downhead.paintIcon(this, g ,snakexlength[a] , snakeylength[a]);

                if((applexpos[xpos] == snakexlength[a] && appleypos[ypos] == snakeylength[a])){
                    score++;
                    lengthofsnake++;
                    xpos = random.nextInt(38);
                    ypos = random.nextInt(21);
                }

            }

            if(a!=0){
                snakebody = new ImageIcon("C:\\Users\\Kent\\AndroidStudioProjects\\Snake_Game\\lib\\snake_body_update.png");
                snakebody.paintIcon(this, g ,snakexlength[a] , snakeylength[a]);

            }

        }

        appleimage.paintIcon(this,g ,applexpos[xpos] ,appleypos[ypos]);

        for(int i = 1; i < lengthofsnake; i++){
            if(snakexlength[i] == snakexlength[0] && snakeylength[i] == snakeylength[0]){
                right = false;
                left = false;
                up = false;
                down = false;

                g.setColor(Color.BLACK);
                g.setFont(new Font("arial",Font.BOLD, 50 ));
                g.drawString("Game Over", 360, 300);

                g.setFont(new Font("arial",Font.BOLD, 20 ));
                g.drawString("Press Space to Restart", 390, 340);
            }
        }

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        timer.start();
        if(right == true){
            for(int y = lengthofsnake -1; y>=0;y--){
                snakeylength[y+1] = snakeylength[y];
            }
            for(int x = lengthofsnake; x >= 0; x--){
                if(x == 0){
                    snakexlength[x] = snakexlength[x] + 25;
                }

                else{
                    snakexlength[x] = snakexlength[x-1];
                }
                if(snakexlength[x] > 960){
                    snakexlength[x] = 25;
                }

            }
            repaint();
        }
        if(left == true){
            for(int y = lengthofsnake -1; y>=0;y--){
                snakeylength[y+1] = snakeylength[y];
            }
            for(int x = lengthofsnake; x >= 0; x--){
                if(x == 0){
                    snakexlength[x] = snakexlength[x] - 25;
                }
                else{
                    snakexlength[x] = snakexlength[x-1];
                }
                if(snakexlength[x] < 25){
                    snakexlength[x] = 960;
                }

            }
            repaint();

        }
        if(up == true){
            for(int x = lengthofsnake -1; x>=0;x--){
                snakexlength[x+1] = snakexlength[x];
            }
            for(int y = lengthofsnake; y >= 0; y--){
                if(y == 0){
                    snakeylength[y] = snakeylength[y] - 25;
                }

                else{
                    snakeylength[y] = snakeylength[y-1];
                }
                if(snakeylength[y] < 175){
                    snakeylength[y] = 775;
                }

            }
            repaint();

        }
        if(down == true){
            for(int x = lengthofsnake -1; x>=0;x--){
                snakexlength[x+1] = snakexlength[x];
            }
            for(int y = lengthofsnake; y >= 0; y--){
                if(y == 0){
                    snakeylength[y] = snakeylength[y] + 25;
                }

                else{
                    snakeylength[y] = snakeylength[y-1];
                }
                if(snakeylength[y] > 775){
                    snakeylength[y] = 175;
                }

            }
            repaint();

        }

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) { // snake move when key press

        if(keyEvent.getKeyCode() == KeyEvent.VK_SPACE){
            moves = 0;
            score = 0;
            lengthofsnake = 3;
            xpos = random.nextInt(38);
            ypos = random.nextInt(21);
            repaint();
        }

        if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT){
            moves++;
            right = true;
            if(!left){
                right = true;
            }
            else {
                right = false;
                left = true;
            }
            up = false;
            down = false;
        }

        if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT){
            moves++;
            left = true;
            if(!right){
                left = true;
            }
            else{
                left = false;
                right = true;
            }

            up = false;
            down = false;
        }

        if(keyEvent.getKeyCode() == KeyEvent.VK_UP){
            moves++;
            up = true;
            if(!down){
                up = true;
            }
            else{
                up = false;
                down = true;
            }

            left = false;
            right = false;
        }

        if(keyEvent.getKeyCode() == KeyEvent.VK_DOWN){
            moves++;
            down = true;
            if(!up){
                down = true;
            }
            else{
                down = false;
                up = true;
            }

            left = false;
            right = false;
        }

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
