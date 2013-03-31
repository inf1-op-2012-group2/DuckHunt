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
public final class NyanCat extends Entity {

    private static Image NYAN_IMAGE = null;
    private static Vector2f NYAN_SIZE = new Vector2f(200, 120);
    private int upper;
    private int right;
    private float yd;
    private float x;
    private float y = 500;
    private float rndShift;
    private boolean catGradient = true;

    public NyanCat(int upper, int right) {
        super("images/original.gif", upper, right, NYAN_SIZE);
        this.upper = upper;
        this.right = right;
    }

    @Override
    public void think(int delta) 
    {   
        if (catGradient) 
        {
            if (y < 0) {
                y = 0;
                catGradient = false;
                System.out.println("1");
            }
            else if ((y -= 0.1f * delta) > 0) {
                y -= 0.1f * delta;
                System.out.println("2");
            }
            else if ((y -= 0.1f * delta) == 0) {
                y += 0.1f * delta;
                catGradient = false;
                System.out.println("3");
            }
            
            if ((x += 0.1f * delta) > 1024) 
            {
                x = 0 + (0.1f * delta);
            }
            if ((x += 0.1f * delta) < 1024) {
                x += 0.1f * delta;
            }
        }
        if (!catGradient) {
            if (y  > 0) {
                y += 1 + 0.1f * delta;
                System.out.println("4");
            }
            if ((y -= 0.1f * delta) == 720) {      
                y -= 0.1f * delta;
                catGradient = true;
                System.out.println("5");
            }
            if (y < 0) {      
                y = 1;
                System.out.println("7");
            }
            if (y > 720) {      
                y = 720;
                catGradient = true;
                System.out.println("6");
            }
            if ((x += 0.1f * delta) > 1024) 
            {
                x = 0 + (0.1f * delta);
            }
            if ((x += 0.1f * delta) < 1024) {
                x += 0.1f * delta;
            }
        }
        System.out.println(catGradient);
        super.setPos((int)x, (int) y);
    }

    @Override
    public void reset() {
        x = 0;
        y = 500;
        rndShift = (float)Math.random();
        super.reset();
    }

}
