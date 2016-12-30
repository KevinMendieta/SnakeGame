package snake.game.controll;

/**
 * @author kevin
 */
public class Food extends Consumables{
    
    public Food(int xPosition, int yPosition){
        super(xPosition, yPosition, 100);
    }

    @Override
    public void consumablePicked(Snake snake) {
        snake.foodPicked(this.score);
    }
}
