/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package duckhunt;
import org.newdawn.slick.*;

public class DuckHunt extends BasicGame
{
    public DuckHunt()
    {
        super("DuckHunt");
    }
    
    @Override public void init(GameContainer gc) throws SlickException
    {
        System.out.println("Init");
    }
    
    @Override public void update(GameContainer gc, int delta) throws SlickException
    {
        System.out.println("Update");
    }
    
    @Override public void render(GameContainer gc, Graphics g) throws SlickException
    {
        System.out.println("Render");
        g.drawString("Woot", 150, 150);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SlickException
    {
        System.out.println("It Works!");
        AppGameContainer app = new AppGameContainer(new DuckHunt());
        
        app.setDisplayMode(640, 480, false);
        app.start();
    }
}
