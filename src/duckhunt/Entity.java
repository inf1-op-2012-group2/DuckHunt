/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package duckhunt;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author rikki
 */
abstract public class Entity {
    
    public Image entityImage = null;
    
    public Vector2f pos, size;

    public abstract void think(int delta);
    
    public void render(Graphics g)
    {
        if(entityImage != null)
            entityImage.draw(pos.x, pos.y);
    }
    
    public boolean contains(Vector2f what)
    {
        if(
            (what.x < pos.x) ||
            (what.y < pos.y) ||
            (what.x > pos.x + size.x) ||
            (what.y > pos.y + size.y)
        ) { return false; }
        else { return true; }
    }
    
    public Entity(Image img, Vector2f pos, Vector2f size)
    {
        this.entityImage = img;
        this.pos = pos;
        this.size = size;
    }    
}
