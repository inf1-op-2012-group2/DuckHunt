/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package duckhunt;
import java.lang.reflect.Field;
import org.newdawn.slick.*;

public class DuckHunt extends BasicGame
{
    
    Image land = null;
    Image cat = null;
    float x = 400;
    float y = 300;
    float scale = 1;
    
    private DuckHunt()
    {
        super("DuckHunt");
    }
    
    @Override public void init(GameContainer gc) throws SlickException
    {
        System.out.println("Init");   
        land = new Image("images/bkgd.jpg");
        cat = new Image ("images/original.gif");
    }
    
    @Override public void update(GameContainer gc, int delta) throws SlickException
    {
        System.out.println("Update");
       Input input = gc.getInput();
 
        if(input.isKeyDown(Input.KEY_LEFT))
        {
            cat.rotate(-0.2f * delta);
        }
 
        if(input.isKeyDown(Input.KEY_RIGHT))
        {
            cat.rotate(0.2f * delta);
        }
 
        if(input.isKeyDown(Input.KEY_UP)) 
        {
            float hyp = 0.4f * delta;
 
            float rotation = cat.getRotation();
 
            x+= hyp * Math.sin(Math.toRadians(rotation));
            y-= hyp * Math.cos(Math.toRadians(rotation));
    
        }
        
        if(input.isKeyDown(Input.KEY_DOWN))
        {
            float hyp = -0.4f * delta;
 
            float rotation = cat.getRotation();
 
            x+= hyp * Math.sin(Math.toRadians(rotation));
            y-= hyp * Math.cos(Math.toRadians(rotation));
    
        }
        
        
    }
    
    @Override public void render(GameContainer gc, Graphics g) throws SlickException
    {
        System.out.println("Render");
        land.draw(0, 0);
        g.drawString("Woot", 150, 150);
        cat.draw(x, y, scale);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SlickException, NoSuchFieldException, IllegalAccessException
    {
        System.out.println("Initialising...");
        String libPath = System.getProperty("user.home") + "/slick-lib/lwjgl-2.8.5/native/linux";
        System.setProperty("java.library.path", libPath);
        System.out.println("Using path: " + System.getProperty("java.library.path"));
        
        //horrible, horrible hax to flush the cached version of java.library.path
        Field fieldSysPath = ClassLoader.class.getDeclaredField("sys_paths");
        fieldSysPath.setAccessible( true );
        fieldSysPath.set( null, null );
        
        AppGameContainer app = new AppGameContainer(new DuckHunt());
        
        app.setDisplayMode(640, 480, false);
        app.start();
    }
}
