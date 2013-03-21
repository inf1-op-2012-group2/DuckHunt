/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package duckhunt;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.OpenGLException;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author rikki
 */
public class GameState extends BasicGameState {
    
    private boolean mousePressed = false;
    private boolean catHit = false;
    private boolean pointScored = false;
    private boolean drawCat = true;
    
    Image land = null;
    NyanCat cat = null;
    Image cursor = null;
    float scale = 1;
        
    private int stateId = -1;
    private int score = 0;
    
    public GameState(int id)
    {
        this.stateId = id;
    }

    @Override public int getID()
    {
        return this.stateId;
    }

    @Override public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
        Music gameMusic = new Music("music/patty.wav");
        
        pointScored = false;
        
        land = new Image("images/duck5.png");
        cat = new NyanCat(new Vector2f(400, 300));
        cursor = new Image("images/cursor.png"); /*Uncompressed PNG 32x32 Required */
        gc.setMouseCursor(cursor, 16, 16); 
        
        gameMusic.loop();
    }

    @Override public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
    {
           
        try {
            land.draw(0, 0);
            
        if (drawCat) {
            cat.render(g);
        }
            
            if (mousePressed && catHit) {
                g.drawString("Cat hit!", 200, 200);
                if (pointScored == false) {
                    score += 20;
                    drawCat = false;
                    pointScored = true;
                    
                }
            }
            
            g.drawString("Score: " + Integer.toString(score), 200, 400);

        } catch (OpenGLException ex) {
            // just ignore it - prevents random crashes 
            System.err.println("OpenGLException: " + ex.getMessage());
        }
    }

    @Override public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException
    {
        int posX = Mouse.getX();
        int posY = Mouse.getY();
        
        
        catHit = cat.contains(new Vector2f(posX, posY));
        
        
        Input input = gc.getInput();
        if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            mousePressed = true;         
        }else{
            mousePressed = false;
        } 
    }
   
}