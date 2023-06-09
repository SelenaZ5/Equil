import javax.swing.*;
import java.awt.*;


public class Main {
    public static void main(String[] args) {
        Frame frame = new Frame();


        frame.setSize(700,700);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((int)(screenSize.getWidth()/2 - frame.getSize().getWidth()/2), (int) (screenSize.getHeight()/2 - frame.getSize().getHeight()/2));


        frame.setResizable(false);
        frame.setTitle("Equil");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
