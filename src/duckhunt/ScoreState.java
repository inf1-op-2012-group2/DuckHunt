/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package duckhunt;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author rikki
 */
public class ScoreState extends BasicGameState {
    
    private int stateId = -1;
    
    public ScoreState(int id)
    {
        this.stateId = id;
    }

    @Override public int getID()
    {
        return this.stateId;
    }

    @Override public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
        //code
    }

    @Override public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException
    {
        grphcs.drawString("Score: " + "thisisnotacore", 100, 600);
        grphcs.fillOval(75, 100, 100, 100);
        grphcs.drawString("Play Again!", 80, 70);
    }

    @Override public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException
    {
        Input input = gc.getInput();
        int xpos = Mouse.getX();
        int ypos = Mouse.getY();
        if((xpos > 75 && xpos < 175)&&(ypos > 160 && ypos < 260)) {
            if(input.isMouseButtonDown(0)) {
                sbg.enterState(DuckHunt.STATE_MENU);
            }
        }
    }
   
}
