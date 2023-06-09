import java.awt.*;

public class Player {

    Panel panel;
    int x;
    int y;
    int wid;
    int hei;
    double speedX;
    double speedY;
    Rectangle box;
    boolean left;
    boolean right;
    boolean Up;
    boolean Down;

    public Player(int x, int y, Panel panel){
        this.panel = panel;
        this.x = x;
        this.y = y;
        wid = 50;
        hei = 50;
        box = new Rectangle(x,y ,wid, hei);
    }

    public void set(){
        //motion control
        if(left && right || !left && !right){
            speedX *= 0.8;
        }else if(left && !right){
            speedX --;
        }else if(right && !left){
            speedX++;
        }
        //sliding speed control
        if(speedX > 0 && speedX < 0.75){
            speedX = 0;
        }
        if(speedX < 0 && speedX > -0.75){
            speedX = 0;
        }
        if(speedX >7 ){
            speedX = 7;
        }
        if(speedX < -7){
            speedX = -7;
        }

        if(Up){
            box.y++;
            for(Obstacles wall: panel.walls){
                if(wall.box.intersects(box)){
                    speedY = -6;
                }
                box.y --;
            }

        }
        speedY += 0.3;

        //horizontal collision
        box.x += speedX;
        for(Obstacles wall: panel.walls){
            if(box.intersects(wall.box)){
                box.x -= speedX;
                while(!wall.box.intersects(box)) box.x += Math.signum(speedX);

                    box.x -= Math.signum(speedX);
                    speedX = 0;
                    x = box.x;
            }
        }
        //vertical collision

        box.y += speedY;
        for(Obstacles wall: panel.walls){
            if(box.intersects(wall.box)){
                box.y -= speedY;
                while(!wall.box.intersects(box))box.y += Math.signum(speedY);
                box.y -= Math.signum(speedY);
                speedY = 0;
                y = box.y;
            }
        }

        x += speedX;
        y += speedY;

        box.x = x;
        box.y = y;
    }

    public void draw(Graphics2D gd){
        gd.setColor(Color.black);
        gd.fillRect(x,y,wid,hei);
    }

}
