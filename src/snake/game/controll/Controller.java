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
    
    public void setDirection(int dx, int dy){
        ArrayList<Tile> tiles  = snake.getTiles();
        for(int i = 0 ; i < tiles.size() ; i++){
            tiles.get(i).setDx(dx);
            tiles.get(i).setDy(dy);
        }
    }
    
    public void move(){
        snake.move();
    }
    
    public ArrayList<Tile> getTiles(){
        return snake.getTiles();
    }
    
    public Snake getSnake(){
        return snake;
    }
    
    public long getScore(){
        return snake.getScore();
    }
}