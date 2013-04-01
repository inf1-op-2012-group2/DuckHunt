package duckhunt;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class DuckHunt extends StateBasedGame {

    public static final int STATE_MENU = 0;
    public static final int STATE_GAME = 1;
    public static final int STATE_SCORE = 2;
    public static int score = 0;

    private DuckHunt() {
        super("DuckHunt");
    }
    private static DuckHunt INSTANCE = new DuckHunt();

    public static DuckHunt getInstance() {
        return INSTANCE;
    }

    public static int getScore() {
        return score;
    }

    public static void setScore(int setScore) {
        score = setScore;
    }

    @Override
    public void initStatesList(GameContainer gc) {
        this.addState(new MenuState(STATE_MENU));
        this.addState(new GameState(STATE_GAME));
        this.addState(new ScoreState(STATE_SCORE));
    }

    public static void main(String[] args) throws SlickException, NoSuchFieldException, IllegalAccessException {
        System.setProperty("org.lwjgl.librarypath", System.getProperty("user.home") + "/slick-lib/lwjgl-2.8.5/native/linux");
        System.setProperty("net.java.games.input.librarypath", System.getProperty("org.lwjgl.librarypath"));

        AppGameContainer app = new AppGameContainer(DuckHunt.getInstance());

        app.setDisplayMode(1024, 720, false);
        app.start();
    }
}
