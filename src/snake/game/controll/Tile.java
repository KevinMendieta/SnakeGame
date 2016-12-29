package snake.game.controll;

/**
 * @author kevin
 */
public class Tile {
 
    //Attributes
    private int xPosition, yPosition, xMax,yMax, dx, dy;
    
    public Tile(int xPosition, int yPosition, int xMax, int yMax){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.xMax = xMax;
        this.yMax = yMax;
        dx = 0; dy = 0;
    }
    
    public void move(){
        if (xPosition+dx<0 && dx != 0){
            xPosition = xMax;
        }else if (xPosition+dx>xMax && dx != 0){
            xPosition = 0;
        }else if (yPosition+dy<0 && dy != 0){
            yPosition = yMax;
        }else if (yPosition+dy>yMax && dy != 0){
            yPosition = 0;
        }else{
            xPosition += dx;
            yPosition += dy;
        }
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }
}