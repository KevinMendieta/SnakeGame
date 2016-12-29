package snake.game.view;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 *
 * @author kevin
 */
public class InputHandler extends KeyAdapter{
	
    private GameCanvas game;

    public InputHandler(GameCanvas game){
        this.game = game;
    }

    @Override
    public void keyPressed(KeyEvent e){
        game.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e){
        game.keyReleased(e);
    }
}