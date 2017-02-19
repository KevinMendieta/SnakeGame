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
    private int width, height,scale;
    
    public Controller(int width, int height, int scale){
        this.width = width;
        this.height = height;
        this.scale = scale;
        snake = new Snake(0, 0, 0, width, height);
        pickConsumable();
    }
    
    public void tick(){
        move();
        checkSnakeCollision();
        checkConsumableCollision();
    }
    
    private void checkSnakeCollision(){
        ArrayList<Tile> currentTiles = getTiles();
        boolean overlap = false;
        for(int i = 1; i < currentTiles.size() && !overlap; i++){
            overlap = intersect(snake.getxPosition(),snake.getyPosition(),currentTiles.get(i).getxPosition(),currentTiles.get(i).getyPosition());
        }
        if(overlap)snake.reset();
    }
    
    public boolean intersect(int x1,int y1,int x2,int y2){
      return x1 < x2+scale && x1+scale > x2 && y1 < y2+scale && y1+scale > y2;
    }
    
    public void checkConsumableCollision(){
        if(intersect(snake.getxPosition(),snake.getyPosition(),consumable.getxPosition(),consumable.getyPosition())){
            consumable.consumablePicked(snake);
            pickConsumable();
        }
    }
    
    public void move(){        
        snake.move();
    }
    
    private void pickConsumable(){
        Random randomno = new Random();
        int x = randomno.nextInt(width);
        int y = randomno.nextInt(width);
        x -= x%scale;
        y -= y%scale;
        consumable = new Food(x,y);
    }
    
    public void setDirection(int dx, int dy){
        snake.setDx(dx);
        snake.setDy(dy);
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