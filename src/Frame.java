import java.awt.*;

public class Frame extends javax.swing.JFrame{

    public Frame(){
        Panel panel = new Panel();
        panel.setLocation(0,0);
        panel.setSize(this.getSize());
        panel.setBackground(SystemColor.PINK);
        panel.setVisible(true);
        this.add(panel);

        addKeyListener(new KeyLogic(panel));
    }

}
