package snake.game.controll;

import java.util.ArrayList;

/**
 * @author KevinMendieta
 */
public class Controller {
    
    //Attributes
    private Snake snake;
    private ArrayList<Consumables> consumables;
    private int width, height;
    
    public Controller(int width, int height){
        this.width = width;
        this.height = height;
        snake = new Snake(0, width, height);
        consumables = new ArrayList<Consumables>();
    }
    
    public void move(int dx, int dy){
        snake.move(dx, dy);
    }
    
    public ArrayList<Tile> getTiles(){
        return snake.getTiles();
    }
    
    public Snake getSnake(){
        return snake;
    }
}