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
    
    static
    {
        try
        {
            NYAN_IMAGE = new Image("images/original.gif");
        }
        catch (SlickException ex)
        {
            Logger.getLogger(NyanCat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public NyanCat(Vector2f pos)
    {
        super(NYAN_IMAGE, pos, NYAN_SIZE);
    }

    @Override
    public void think(int delta)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
