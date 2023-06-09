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
    int currentColor;
    public Player(){

    }
    public Player(int x, int y, Panel panel){
        this.panel = panel;
        this.x = x;
        this.y = y;
        wid = 50;
        hei = 50;
        box = new Rectangle(x,y ,wid, hei);
        currentColor = 0;
    }

    public boolean intersects(Player p){
        int tw = this.wid;
        int th = this.hei;
        int rw = p.wid;
        int rh = p.hei;
        if(rw <= 0 || rh <= 0 || tw <= 0 || th <= 0){
            return false;
        }
        int tx = this.x;
        int ty = this.y;
        int rx = p.x;
        int ry = p.y;
        rw += rx;
        rh += ry;
        tw += tx;
        th += ty;
        return ((rw < rx || rw > tx) &&
                (rh < ry || rh > ty) &&
                (tw < tx || tw > rx) &&
                (th < ty || th > ry));
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
                    speedY = -11;
                }
                box.y --;
            }

        }
        speedY += 0.5;// gravity

        //horizontal collision
        box.x += speedX;
        for(Obstacles wall: panel.walls){
            if(box.intersects(wall.box)){
                box.x -= speedX;
                while(!wall.box.intersects(box)) box.x += Math.signum(speedX);

                    box.x -= Math.signum(speedX);
                    panel.cameraX += x - box.x;
                    speedX = 0;
                    box.x = x;
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

        panel.cameraX -= speedX;
        y += speedY;

        box.x = x;
        box.y = y;



        //died
        if(y > 800){
            panel.reset();
        }
    }

    public void draw(Graphics2D gd){
        if (currentColor == 2 || currentColor == 0) {
            gd.setColor(Color.BLACK);
            gd.fillRect(x, y, wid, hei);
            currentColor = 2;
        }
        if (currentColor == 1) {
            gd.setColor(Color.WHITE);
            gd.fillRect(x, y, wid, hei);
            currentColor = 1;
        }
    }
    public void changeColor(){
        //currently white
        if(currentColor == 1){

            currentColor = 2;
        }
        else if(currentColor ==2){ // currently black

            currentColor = 1;
        }
    }

}
