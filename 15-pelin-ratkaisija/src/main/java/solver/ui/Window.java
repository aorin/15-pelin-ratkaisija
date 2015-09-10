package solver.ui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;
import solver.logic.domain.State;
import solver.ui.listeners.NewGameButtonListener;
import solver.ui.listeners.SolveButtonListener;

/**
 * Luokka luo käyttöliittymäikkunan ja ohjaa sen toimintaa.
 */
public class Window implements Runnable {

    private JFrame frame;
    private State gameState;
    private Renderer renderer;

    public Window(State state) {
        this.gameState = state;
    }

    @Override
    public void run() {
        frame = new JFrame("15-pelin ratkaisija");
        frame.getContentPane().setPreferredSize(new Dimension(4 * 100 + 1, 4 * 100 + 1));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());
        createMenuBar();

        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void createMenuBar() {
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);

        JMenuItem newGame = new JMenuItem("Arvo uusi");
        JMenuItem solve = new JMenuItem("Ratkaise");

        menubar.add(newGame);
        menubar.add(solve);

        NewGameButtonListener listener1 = new NewGameButtonListener(this);
        newGame.addActionListener(listener1);

        SolveButtonListener listener2 = new SolveButtonListener(gameState);
        solve.addActionListener(listener2);
    }

    private void createComponents(Container container) {
        renderer = new Renderer(gameState, 100);
        container.add(renderer);
    }

    public JFrame getFrame() {
        return frame;
    }

    /**
     * Metodi päivittää käyttöliittymän vastaamaan metodina annettua pelitilaa.
     *
     * @param gameState Uusi käytössä oleva pelitila.
     */
    public void update(State gameState) {
        this.gameState = gameState;
        Container c = frame.getContentPane();
        c.removeAll();
        createComponents(c);

        JMenuBar menu = frame.getJMenuBar();
        menu.removeAll();
        createMenuBar();

        frame.setVisible(true);
    }
}