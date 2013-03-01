/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package duckhunt;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author rikki
 */
public class GameState extends BasicGameState {
    
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
        //init that thing
    }

    @Override public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException
    {
        //render stuff
    }

    @Override public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException
    {
        //update stuff
    }
   
}
