/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package duckhunt;

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

    
    public NyanCat(int upper, int right)
    {
        super("images/original.gif", randomVector(upper,right), NYAN_SIZE);
        this.upper = upper;
        this.right = right;
    }

    @Override
    public void think(int delta)
    {
        
    }
    
    public void reset() {
        super.setPos(randomVector(this.upper,this.right));
    }
    
    public static Vector2f randomVector(int upper, int right){
        int coordx = (int) (Math.random() * right);
        int coordy = (int) (Math.random() * upper);
        return new Vector2f(coordx,coordy);
    }
        
}
    
