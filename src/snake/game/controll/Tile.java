package snake.game.controll;

/**
 * @author KevinMendieta
 * This object simulates each part of the tail of the snake
 */
public class Tile {
 
    //Attributes
    private final int xPosition, yPosition;
    
    public Tile(int xPosition, int yPosition){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }
}