/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package duckhunt;
import org.lwjgl.input.Mouse;
import java.lang.reflect.Field;
import org.lwjgl.opengl.OpenGLException;
import org.newdawn.slick.*;

public class DuckHunt extends BasicGame
{
    
    private boolean mousePressed = false;
    
    Image land = null;
    Image cat = null;
    Image cursor = null;
    float x = 400;
    float y = 300;
    float scale = 1;
    
    public String mouse = "No input yet!";
    
    private DuckHunt()
    {
        super("DuckHunt");
    }
    
    @Override public void init(GameContainer gc) throws SlickException
    {
        System.out.println("Init");   
        land = new Image("images/bkgd.jpg");
        cat = new Image ("images/original.gif");
        cursor = new Image("images/cursor.png"); /*Uncompressed PNG 32x32 Required */
        gc.setMouseCursor(cursor,0,0); 
    }
    
    @Override public void update(GameContainer gc, int delta) throws SlickException
    {
        System.out.println("Update");
        int posX = Mouse.getX();
        int posY = Mouse.getY();
        
        mouse = "Mouse Co-Ords, x: " + posX + " y: " + posY;
        
        Input input = gc.getInput();
        if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            mousePressed = true;         
        }else{
            mousePressed = false;
        }
        
        
     }
    
    @Override public void render(GameContainer gc, Graphics g) throws SlickException
    {
        try {
        System.out.println("Render");
        land.draw(0, 0);
        g.drawString(mouse, 50, 50);
        cat.draw(x, y, scale); 
        if (mousePressed == true) {
            g.drawString("Mouse pressed!", 100, 100);
        }
        } catch (OpenGLException ex) {
            // just ignore it - prevents random crashes 
        }
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
