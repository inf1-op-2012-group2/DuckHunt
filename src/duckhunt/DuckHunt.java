/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package duckhunt;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class DuckHunt extends StateBasedGame
{
    private DuckHunt()
    {
        super("DuckHunt");
    }
    
    private static DuckHunt INSTANCE;
    final public static DuckHunt getInstance()
    {
        if(INSTANCE == null) INSTANCE = new DuckHunt();
        return INSTANCE;
    }
    
    @Override public void initStatesList(GameContainer gc)
    {
        // no states yet
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SlickException, NoSuchFieldException, IllegalAccessException
    {
        System.setProperty("org.lwjgl.librarypath", System.getProperty("user.home") + "/slick-lib/lwjgl-2.8.5/native/linux");
        System.setProperty("net.java.games.input.librarypath", System.getProperty("org.lwjgl.librarypath"));
        
        AppGameContainer app = new AppGameContainer(DuckHunt.getInstance());
        
        app.setDisplayMode(640, 480, false);
        app.start();
    }
}
