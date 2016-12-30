package snake.game.controll;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author KevinMendieta
 */
public class Controller {
    
    //Attributes
    private Snake snake;
    private Consumables consumable;
    private int width, height;
    
    public Controller(int width, int height){
        this.width = width;
        this.height = height;
        snake = new Snake(0, 0, 0, width, height);
        pickConsumable();
    }
    
    public void pickConsumable(){
        Random randomno = new Random();
        int x = randomno.nextInt(width);
        int y = randomno.nextInt(width);
        x -= x%40;
        y -= y%40;
        consumable = new Food(x,y);
    }
    
    public void setDirection(int dx, int dy){
        snake.setDx(dx);
        snake.setDy(dy);
    }
    
    public void move(){
        Rectangle snakeRectangle = new Rectangle(snake.getxPosition(), snake.getyPosition(), 20, 20);
        Rectangle consumableRectangle = new Rectangle(consumable.getxPosition(), consumable.getyPosition(), 20, 20);
        if(snakeRectangle.intersects(consumableRectangle)){
            consumable.consumablePicked(snake);
            pickConsumable();
        };
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
    
    public Consumables getConsumable(){
        return consumable;
    }
}