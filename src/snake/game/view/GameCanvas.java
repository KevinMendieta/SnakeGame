package snake.game.view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import javax.swing.JFrame;
import snake.game.controll.Controller;
import snake.game.controll.Tile;

/**
 * @author KevinMendieta
 */
public class GameCanvas extends Canvas implements Runnable{
    
    private static final long serialVersionUID = 1L;
    public static final int WIDTH = 320;
    public static final int HEIGHT = 320;
    public static final int SCALE = 2;
    public String boardFps;
    public static final int BOARDSCALE = WIDTH*SCALE/40;
    public final String TITLE = "Snake Game";
    
    private boolean running = false;
    private Thread thread;
    
    //Game Attributes
    private Controller controller;
    
    public void init(){
        requestFocus();
        // Add keyboard listener
	addKeyListener(new InputHandler(this));
        controller = new Controller(WIDTH*SCALE, HEIGHT*SCALE, BOARDSCALE);        
    }
    
    public void setDirection(int dx, int dy){
        controller.setDirection(dx, dy);
    }
    
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        int velocity = BOARDSCALE;
        if(key==KeyEvent.VK_RIGHT){            
            setDirection(velocity,0);
        }
        if(key==KeyEvent.VK_LEFT){
            setDirection(-velocity,0);
        }
        if(key==KeyEvent.VK_UP){
            setDirection(0,-velocity);            
        }
        if(key==KeyEvent.VK_DOWN){
            setDirection(0,velocity);
        }
    }
    
    public void keyReleased(KeyEvent e) {
        /*int key = e.getKeyCode();
        if(key==KeyEvent.VK_RIGHT){
            setDirection(0,0);
        }
        if(key==KeyEvent.VK_LEFT){
            setDirection(0,0);
        }
        if(key==KeyEvent.VK_UP){
            setDirection(0,0);
        }
        if(key==KeyEvent.VK_DOWN){
            setDirection(0,0);
        }*/
    }
    
    private synchronized void start(){
        if(running) return;

        running = true;
        thread = new Thread(this);
        thread.start();
    }
	
    private synchronized void stop(){
        if(!running) return;

        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(1);
    }
	
    /*
     * Game thread runner. 
     */
    @Override
    public void run() {
        init();

        long lastTime = System.nanoTime();
        final double numOfTicks = 60.0;
        double ns = 1000000000 / numOfTicks;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();

        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if(delta >= 1){
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                boardFps = frames+"";
                System.out.println(updates + "ticks, fps " + frames);
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }
	
    /*
     * Run the ticks of all game components.
     */
    public void tick(){
        controller.tick();
    }
	
    /*
     * Render overall game components.
     */
    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        //Rendering the game
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
        ArrayList<Tile> tiles = controller.getTiles();
        g.setFont(new Font("Century Gothic",Font.PLAIN,30));
        g.setColor(Color.WHITE);
        g.drawString("Score: "+controller.getScore(), 25, 30);
        g.drawString("FPS = "+boardFps, 500, 30);
        Tile currentTile;
        g.setColor(Color.WHITE);     
        for (int i = 0 ; i < tiles.size() ; i++){
            currentTile = tiles.get(i);
            g.fillRect(currentTile.getxPosition(), currentTile.getyPosition(), BOARDSCALE, BOARDSCALE);
        }
        g.setColor(Color.RED);
        g.fillRect(controller.getConsumable().getxPosition(), controller.getConsumable().getyPosition(), BOARDSCALE, BOARDSCALE);
        //Pausing the thread in order that the snake moves slower
        try{
            Thread.sleep(30);
        }catch(Exception e){
            e.printStackTrace();
        }
        //End rendering the game
        //g.dispose();
        bs.show();
    }
	
    public static void main(String args[]){		
        GameCanvas game = new GameCanvas();
        game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        JFrame frame = new JFrame(game.TITLE);
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        game.start();
    }
}