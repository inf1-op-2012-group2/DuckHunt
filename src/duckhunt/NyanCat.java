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
    private float x = (float) Math.random() * 824;
    private float y = (float) Math.random() * 600;
    private float rndShift;
    private boolean catGradient = true;
    private boolean xPositive = true;

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
            }
            else if ((y -= 0.1f * delta) > 0) {
                y -= 0.1f * delta;
            }
            else if ((y -= 0.1f * delta) == 0) {
                y += 0.1f * delta;
                catGradient = false;
            }
            if (xPositive) {
                if (x > 0 && x < 824) {
                    x += 0.1f * delta;
                }
                else if (x < 0) {
                    x = 0;
                }
                else if (x > 824) {
                    x = 1024;
                    xPositive = false;
                }
                else if (x == 0) {
                    x += 1 + 0.1f * delta; 
                }
                else if (x == 824) {
                    xPositive = false;
                    x -= 1 + 0.1 * delta;
                }
            }
            if (!xPositive) {
                if (x > 0) {
                    x -= 0.1f * delta;
                }
                if (x < 0) {
                    x = 0;
                    xPositive = true;
                }
                if (x > 824) {
                    x = 824;
                }
                if (x == 0) {
                    x += 1 + 0.1f * delta; 
                    xPositive = true;
                }
            }
        }
        if (!catGradient) {
            if (y  > 0) {
                y += 1 + 0.1f * delta;
            }
            if ((y -= 0.1f * delta) == 620) {      
                y -= 0.1f * delta;
                catGradient = true;
            }
            if (y < 0) {      
                y = 1;
            }
            if (y > 600) {      
                y = 600;
                catGradient = true;
            }
            if (xPositive) {
                if (x > 0 && x < 824) {
                    x += 0.1f * delta;
                }
                else if (x < 0) {
                    x = 0;
                }
                else if (x > 824) {
                    x = 1024;
                    xPositive = false;
                }
                else if (x == 0) {
                    x += 1 + 0.1f * delta; 
                }
                else if (x == 824) {
                    xPositive = false;
                    x -= 1 + 0.1 * delta;
                }
            }
            if (!xPositive) {
                if (x > 0) {
                    x -= 0.1f * delta;
                }
                if (x < 0) {
                    x = 0;
                    xPositive = true;
                }
                if (x > 824) {
                    x = 824;
                }
                if (x == 0) {
                    x += 1 + 0.1f * delta; 
                    xPositive = true;
                }
            }
        }
        System.out.println(xPositive);
        super.setPos((int)x, (int) y);
    }

    @Override
    public void reset() {
        x = (int) Math.random() * 824;      
        y = (int) Math.random() * 600;
        super.reset();
    }

}
