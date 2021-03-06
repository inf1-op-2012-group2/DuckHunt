package duckhunt;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

abstract public class Entity {

    public Image entityImage = null;
    private Vector2f pos;
    private Vector2f size;
    private Vector2f ran;
    private int upper;
    private int right;

    public abstract void think(int delta);

    public void setPos(Vector2f v) {
        this.pos = v;
    }

    public void setPos(int x, int y) {
        this.pos.x = x;
        this.pos.y = y;
    }

    public Vector2f getPos() {
        return this.pos;
    }

    public void render(Graphics g) {
        if (entityImage != null) {
            entityImage.draw(pos.x, pos.y);
        }
    }

    public boolean contains(Vector2f what) {
        System.out.println(what.toString());
        System.out.println(pos.toString());
        if ((what.x > pos.x)
                && (what.y > pos.y)
                && (what.x < pos.x + size.x)
                && (what.y < pos.y + size.y)) {
            return true;
        } else {
            return false;
        }
    }

    public Entity(String imgPath, int upper, int right, Vector2f size) {
        try {
            this.entityImage = new Image(imgPath);
        } catch (SlickException ex) {
            Logger.getLogger(NyanCat.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.pos = randomVector(upper, right, this.entityImage.getWidth(), this.entityImage.getHeight());
        this.size = size;
        this.upper = upper;
        this.right = right;

    }

    public static Vector2f randomVector(int upper, int right, int width, int height) {
        int coordx = (int) (Math.random() * (right - width));
        int coordy = (int) (Math.random() * (upper - height));
        return new Vector2f(coordx, coordy);
    }

    public void reset() {
        setPos(randomVector(this.upper, this.right, this.entityImage.getWidth(), this.entityImage.getHeight()));
    }
}
