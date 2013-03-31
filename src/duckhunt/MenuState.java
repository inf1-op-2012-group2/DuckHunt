/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package duckhunt;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Music;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;



/**
 *
 * @author rikki
 */
public class MenuState extends BasicGameState {
    
    private int stateId = -1;
    Music menuMusic = null;
    
    public MenuState(int id)
    {
        this.stateId = id;
    }

    @Override public int getID()
    {
        return this.stateId;
    }

    @Override public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
    { 
        menuMusic = new Music("music/menu.wav");
        
        menuMusic.loop();
    }

    @Override public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException
    {
        grphcs.fillOval(75, 100, 100, 100);
        grphcs.drawString("Play Now!", 80, 70);
    }

    @Override public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException
    {
        Input input = gc.getInput();
        int xpos = Mouse.getX();
        int ypos = Mouse.getY();
        if((xpos > 75 && xpos < 175)&&(ypos > 160 && ypos < 260)) {
            if(input.isMouseButtonDown(0)) {
                sbg.enterState(DuckHunt.STATE_GAME);
            }
        }
    } 
   
}
