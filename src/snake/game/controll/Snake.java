package snake.game.controll;

import java.util.ArrayList;

/**
 * @author kevin
 */
public class Snake {
    
    //Attributes
    private int xMax,yMax;
    private long score;
    private ArrayList<Tile> tiles;
    
    public Snake(long score, int xMax, int yMax){
        this.score = score;
        this.xMax = xMax;
        this.yMax = yMax;
        initTiles();
        
    }
    
    private void initTiles(){
        tiles = new ArrayList<Tile>();
        tiles.add(new Tile(0,0,xMax,yMax));
    }
    
    public void move(int dx, int dy){
        for(int i = 0; i < tiles.size(); i++){
            tiles.get(i).move(dx, dy);
        }        
    }
    
    public ArrayList<Tile> getTiles(){
        return tiles;
    }
    
}