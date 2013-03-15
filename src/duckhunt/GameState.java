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
    
    Image land = null;
    NyanCat cat = null;
    Image cursor = null;
    float scale = 1;
    
    public String mouse = "No input yet!";
    
    private int stateId = -1;
    
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

        land = new Image("images/bkgd.jpg");
        cat = new NyanCat(new Vector2f(400, 300));
        cursor = new Image("images/cursor.png"); /*Uncompressed PNG 32x32 Required */
        gc.setMouseCursor(cursor, 16, 16); 
        
        gameMusic.loop();
    }

    @Override public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
    {
        try {
            land.draw(0, 0);
            g.drawString(mouse, 50, 50);
            cat.render(g);
            if (mousePressed == true) {
                g.drawString("Mouse pressed!", 100, 100);
            }
        } catch (OpenGLException ex) {
            // just ignore it - prevents random crashes 
            System.err.println("OpenGLException: " + ex.getMessage());
        }
    }

    @Override public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException
    {
        int posX = Mouse.getX();
        int posY = Mouse.getY();
        
        mouse = "Mouse Co-Ords, x: " + posX + " y: " + posY;
        
        Input input = gc.getInput();
        if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            mousePressed = true;         
        }else{
            mousePressed = false;
        } 
    }
   
}
