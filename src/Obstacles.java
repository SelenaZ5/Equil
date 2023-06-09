import org.w3c.dom.css.Rect;

import java.awt.*;

public class Obstacles {
    int x;
    int y;
    int wid;
    int hei;

    Rectangle box;
    public Obstacles(int x, int y, int wid, int hei){
        this.x = x;
        this.y = y;
        this.wid = wid;
        this.hei = hei;

        box = new Rectangle(x, y, wid, hei);

    }

    public void draw(Graphics2D gd){
        gd.setColor(Color.BLACK);
        gd.drawRect(x,y,wid,hei);
        gd.setColor(Color.white);
        gd.fillRect(x+1,y+1,wid-2,hei-2);
    }
}
