import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyLogic extends KeyAdapter {

    Panel panel;

    public KeyLogic(Panel panel){
        this.panel = panel;
    }
    @Override
    public void keyPressed(KeyEvent e){
        panel.keyPressed(e);
    }
    @Override
    public void keyReleased(KeyEvent e){
        panel.keyReleased(e);
    }
}
