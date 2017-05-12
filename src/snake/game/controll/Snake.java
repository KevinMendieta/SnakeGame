package snake.game.controll;

import java.util.ArrayList;

/**
 * @author kevin
 * This object simulates the head of the snake
 */
public class Snake {
    
    //Attributes
    private int xPosition, yPosition, xMax,yMax, dx, dy;
    private long score;
    private ArrayList<Tile> tiles;
    private int numTiles;
    
    public Snake(int xPosition, int yPosition,long score, int xMax, int yMax){
        this.numTiles = 1;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.score = score;
        this.xMax = xMax;
        this.yMax = yMax;
        this.dx = 0;
        this.dy  = 0;
        initTiles();
    }
    
    private void initTiles(){
        tiles = new ArrayList<>();
        tiles.add(new Tile(0,0));
    }
    
    public void move(){
        if(numTiles == tiles.size()){
            for(int i = 0; i < tiles.size()-1; i++){
                tiles.set(i, tiles.get(i+1));
            }
            tiles.set(tiles.size()-1,new Tile(this.xPosition,this.yPosition));
        }else{
            tiles.add(new Tile(this.xPosition,this.yPosition));
        }     
        tiles.set(tiles.size()-1,new Tile(this.xPosition,this.yPosition));
        if (xPosition + dx < 0 && dx != 0){
            xPosition = xMax + dx;
        }else if (xPosition + dx > xMax - dx && dx != 0){
            xPosition = 0;
        }else if (yPosition + dy < 0 && dy != 0){
            yPosition = yMax + dy;
        }else if (yPosition + dy > yMax - dy && dy != 0){
            yPosition = 0;
        }else{
            xPosition += dx;
            yPosition += dy;
        }
    }
    
    public void reset(){
        this.numTiles = 1;
        this.xPosition = 0;
        this.yPosition = 0;
        this.score = 0;
        this.dx = 0;
        this.dy  = 0;
        initTiles();
    }
    
    public ArrayList<Tile> getTiles(){
        return tiles;
    }
    
    public long getScore(){
        return score;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setDx(int dx) {
        if(this.dx+dx!=0)this.dx = dx;
    }

    public void setDy(int dy) {
        if(this.dy+dy!=0)this.dy = dy;
    }
    
    public void foodPicked(long score){
        this.score += score;
        this.numTiles += 1;
    }    
}