import org.w3c.dom.css.Rect;

import java.awt.*;
import java.sql.PreparedStatement;

public class Obstacles {
    int x;
    int y;
    int wid;
    int hei;

    int startX;
    Color color;
    int currentColor;
    Rectangle box;
    public Obstacles(Color color, int x, int y, int wid, int hei){
        this.color = color;
        if(color.equals(Color.BLACK)){
            currentColor = 2;
        }else{
            currentColor = 1;
        }
        this.x = x;
        startX = x;
        this.y = y;
        this.wid = wid;
        this.hei = hei;

        box = new Rectangle(x, y, wid, hei);

    }

    public void draw(Graphics2D gd){
        gd.setColor(Color.BLACK);
        gd.drawRect(x,y,wid,hei);
        gd.setColor(color);
        gd.fillRect(x+1,y+1,wid-2,hei-2);

    }

    public int set(int cam){
        x =startX + cam;
        box.x = x;

        return x;
    }
}
