package snake.game.controll;

/**
 * @author kevin
 */
public abstract class Consumables {

    //Attributes
    private int xPosition, yPosition;
    private long score;
    
    public Consumables(int xPosition, int yPosition, long score){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.score = score;
    }
    
    public abstract void consumablePicked(Snake sanke);
    
}
