package snake.game.controll;

/**
 * @author kevin
 */
public class Tile {
 
    //Attributes
    private int xPosition, yPosition, xMax,yMax;
    
    public Tile(int xPosition, int yPosition, int xMax, int yMax){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }
    
    public void move(int dx, int dy){
        if (xPosition+dx<0){
            xPosition = xMax;
        }else if (xPosition+dx>xMax){
            xPosition = 0;
        }else if (yPosition+dy<0){
            yPosition = yMax;
        }else if (yPosition+dy>yMax){
            yPosition = 0;
        }else{
            xPosition += dx;
            yPosition += dy;
        }
    }
    
}