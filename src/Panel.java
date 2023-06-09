import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Panel extends javax.swing.JPanel implements ActionListener {

    Player player;
    detectColor switchColor;
    Rectangle restartRect;
    Rectangle home;
    int cameraX;
    int offset;
    boolean toSwitch;
    ArrayList<Obstacles> walls = new ArrayList<Obstacles>();
    Timer timer;
    public Panel(){
        restartRect = new Rectangle(550,25,50,50);
        home = new Rectangle(625,25,50,50);

        player = new Player(400,300,this);
        switchColor = new detectColor();
        reset();

        toSwitch = false;
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(walls.get(walls.size() -1).x < 800){
                    offset += 700;
                    createWalls(offset);
                }

                player.set();
                for(Obstacles wall: walls){
                    wall.set(cameraX);
                }
                for(int i = 0; i < walls.size(); i++){
                    if(walls.get(i).x < -800){
                        walls.remove(i);
                    }
                }
                repaint();
            }
        }, 0, 17);
    }

    public void reset(){
        player.x = 200;
        player.y = 0;
        cameraX = 150;
        player.speedX = 0;
        player.speedY = 0;
        walls.clear();
        offset = -150;
        createWalls(offset);
    }
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D gd = (Graphics2D) g;
        player.draw(gd);
        for(Obstacles wall : walls){
            wall.draw(gd);
        }
//        if(toSwitch){
//            player.changeColor();
//            switchColor = new detectColor();
//            switchColor.draw(gd);
//            System.out.println("Not Workign!");;
//        }
//        toSwitch = false;
    }

    public void createWalls(int o){
        int a = 50;
        Random rand = new Random();
        int idx = rand.nextInt(5);

        if(idx == 0){
            for(int i = 0; i < 18; i++){
                walls.add(new Obstacles(Color.WHITE, o + 350+ i*50, 550, a,a));
            }
            for(int i = 0; i < 10 ; i++){
                walls.add(new Obstacles(Color.BLACK,o + i *50, 600,a,a));
            }
            for(int i = 0; i < 10 ; i++){
                walls.add(new Obstacles(Color.BLACK,o + 50 + i *50, 550,a,a));
            }
            System.out.println(idx);
        }
        else if( idx == 1){
            for(int i = 0; i < 14; i++){
                walls.add(new Obstacles(Color.WHITE, o + i*50, 600, a,a));
            }
            for(int i = 0; i < 18; i++){
                walls.add(new Obstacles(Color.WHITE, o + 350+ i*50, 500, a,a));
            }

            for(int i = 0; i < 18; i++){
                walls.add(new Obstacles(Color.WHITE, o + 150+  i*50, 450, a,a));
            }
            for(int i = 0; i < 12; i++){
                walls.add(new Obstacles(Color.WHITE, o + 50 + i *50, 550, a,a));
            }
            System.out.println(idx);
        }
        else if( idx == 2){
            for(int i = 0; i < 14; i++){
                walls.add(new Obstacles(Color.BLACK, o + i*50, 600, a,a));
            }
            for(int i = 0; i < 18; i++){
                walls.add(new Obstacles(Color.WHITE, o + 100+  i*50, 550, a,a));
            }
            for(int i = 0; i < 12; i++){
                walls.add(new Obstacles(Color.BLACK, o + 150 + i *50, 500, a,a));
            }

            for(int i = 0; i < 4; i++){
                walls.add(new Obstacles(Color.WHITE, o + 350 + i*50, 400, a,a));
            }
            for(int i = 0; i < 7; i++){
                walls.add(new Obstacles(Color.BLACK, o + 350+  i*50, 650, a,a));
            }
            System.out.println(idx);
        }
        else if(idx == 3){

            for(int i = 0; i < 14; i++){
                walls.add(new Obstacles(Color.WHITE, o + i*50, 600, a,a));
            }
            for(int i = 0; i < 18; i++){
                walls.add(new Obstacles(Color.BLACK, o + 200 +  i*50, 450, a,a));
            }
            for(int i = 0; i < 4; i++){
                walls.add(new Obstacles(Color.BLACK, o + 250 +  i*50, 500, a,a));
            }
            for(int i = 0; i < 4; i++){
                walls.add(new Obstacles(Color.BLACK, o + 300 +  i*50, 500, a,a));
            }
            System.out.println(idx);
        }
        else if(idx == 4){
                walls.add(new Obstacles(Color.BLACK, o + 500, 600, a,a));
            walls.add(new Obstacles(Color.BLACK, o + 550, 550, a,a));
                walls.add(new Obstacles(Color.WHITE, o + 600, 650, a,a));
            walls.add(new Obstacles(Color.WHITE, o + 650, 650, a,a));
                walls.add(new Obstacles(Color.WHITE, o + 700, 650, a,a));
            for(int i = 0; i < 6; i++){
                walls.add(new Obstacles(Color.BLACK, o + 750, 500, a,a));
            }
            System.out.println(idx);
        }

        else if(idx == 5){
            walls.add(new Obstacles(Color.BLACK, o + 500, 600, a,a));
            for(int i = 0; i < 9; i++){
                walls.add(new Obstacles(Color.BLACK, o + 750, 500, a,a));
            }System.out.println(idx);

        }
    }

//    public void checkCollision(){
//        if(player.intersects(walls) && walls.currentColor){
//            reset();
//        }
//    }


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
        if(e.getKeyChar() =='r' ) {
            reset();
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
        //switch colors
        if(e.getKeyCode() == KeyEvent.VK_SPACE ) {
            player.changeColor();
            toSwitch = true;
           // System.out.println("SWitxh!");
        }
        else{
            toSwitch = false;
        }
    }
}
