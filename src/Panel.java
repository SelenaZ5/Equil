import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Panel extends javax.swing.JPanel implements ActionListener {

    Player player;
    ArrayList<Obstacles> walls = new ArrayList<Obstacles>();
    Timer timer;
    public Panel(){
        player = new Player(400,300,this);
        createWalls(50);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                player.set();
                repaint();
            }
        }, 0, 17);
    }

    public void reset(){
        player.x = 200;
        player.y = 150;
        player.speedX = 0;
        player.speedY = 0;
        walls.clear();
        int offset = 50;
        createWalls(offset);
    }
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D gd = (Graphics2D) g;
        player.draw(gd);
        for(Obstacles wall : walls){
            wall.draw(gd);
        }
    }

    public void createWalls(int o){
        for(int i = 50; i < 650; i+= 50){
            walls.add(new Obstacles(i, 600, 50, 50));
        }
        walls.add(new Obstacles(50,550,50,50));
        walls.add(new Obstacles(50,500,50,50));
        walls.add(new Obstacles(50,450,50,50));
        walls.add(new Obstacles(600,550,50,50));
        walls.add(new Obstacles(600,500,50,50));
        walls.add(new Obstacles(600,450,50,50));
        walls.add(new Obstacles(450,550,50,50));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            player.left = true;

        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT ){
            player.right = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP ){
            player.Up = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN ) {
            player.Down = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            player.left = false;

        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT ){
            player.right = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP ){
            player.Up = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN ) {
            player.Down = false;
        }
    }
}
