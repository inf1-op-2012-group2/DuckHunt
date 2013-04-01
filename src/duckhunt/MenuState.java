/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package duckhunt;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Music;
import org.newdawn.slick.Input;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;



/**
 *
 * @author rikki
 */
public class MenuState extends BasicGameState {
    
    private int stateId = -1;
    private UnicodeFont unicodeFont;
    
    Image playButton;
    
    
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
        gc.setShowFPS(false);
        
        playButton = new Image("images/play.png");
        
        unicodeFont = new UnicodeFont("fonts/Arial.ttf", 40, false, false);
        unicodeFont.getEffects().add(new ColorEffect(java.awt.Color.black));
        
        //sbg.enterState(1);
    }

    @Override public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException
    {     
        grphcs.setBackground(Color.white);
        playButton.drawCentered(512, 360);
        
        String text = "Play Now";
        unicodeFont.drawString((512 - (unicodeFont.getWidth(text) / 2)), 530, text);
        unicodeFont.addGlyphs("~!@!#!#$%___--");

    }

    @Override public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException
    {
        unicodeFont.loadGlyphs(1);
        Input input = gc.getInput();
        int xpos = Mouse.getX();
        int ypos = Mouse.getY();
        if((xpos > 362 && xpos < 662)&&(ypos > 210 && ypos < 510)) {
            if(input.isMouseButtonDown(0)) {
                sbg.enterState(DuckHunt.STATE_GAME);
            }
        }
    } 
}
