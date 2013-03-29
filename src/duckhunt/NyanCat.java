/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package duckhunt;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author rikki
 */
public final class NyanCat extends Entity
{
    private static Image NYAN_IMAGE = null;
    private static Vector2f NYAN_SIZE = new Vector2f(200, 120);
    private int upper;
    private int right;
    private float yd;
    private float x;
    private float y;

    
    public NyanCat(int upper, int right)
    {
        super("images/original.gif", randomVector(upper,right), NYAN_SIZE);
        this.upper = upper;
        this.right = right;
    }

    @Override
    public void think(int delta)
    {
        x += 0.1f * delta;
        y += 0.1f * delta;
            
        super.setPos((int)x, (int)(400* Math.sin(x / 1000)));
    }
    
    public int generateX(){
                return 200; //SPAWN AREA
        }
    
    public void reset() {
        x = (int) (Math.random() * right);
        y = (int) (Math.random() * upper);
        super.setPos(randomVector(this.upper,this.right));
    }
    
    public static Vector2f randomVector(int upper, int right){
        int coordx = (int) (Math.random() * right);
        int coordy = (int) (Math.random() * upper);
        return new Vector2f(coordx,coordy);
    }
    
    public void Move(int delta){
                yd += 0.1f * delta;
                if(this.y+yd > 500){
                        this.x = generateX();
                        this.y = 0;
                }
                else{
                        this.y += yd;
                        yd = 0;
                }
        }
        
}
    
