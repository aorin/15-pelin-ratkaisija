package solver.ui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;
import solver.logic.domain.Puzzle;
import solver.logic.util.GameboardGenerator;
import solver.ui.listeners.ChangeGameButtonListener;
import solver.ui.listeners.NewGameButtonListener;
import solver.ui.listeners.SolveButtonListener;

/**
 * Luokka luo käyttöliittymäikkunan ja ohjaa sen toimintaa.
 */
public class Window implements Runnable {
    private GameboardGenerator generator;
    private JFrame frame;
    private Puzzle puzzle;
    private Renderer renderer;

    /**
     * Konstruktorissa asetetaan käyttöliittymällä käytössä oleva peli 
     * @param puzzle Käytössä oleva peliasetelma
     * @param generator Uusien peliasetelmien generaattori
     */
    public Window(Puzzle puzzle, GameboardGenerator generator) {
        this.puzzle = puzzle;
        this.generator = generator;
    }

    @Override
    public void run() {
        frame = new JFrame("15-pelin ratkaisija");
        frame.getContentPane().setPreferredSize(new Dimension(puzzle.n() * 100 + 1, puzzle.n() * 100 + 1));

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
        JMenuItem changeGame = new JMenuItem();
        if (puzzle.values().length == 4) {
            changeGame.setText("8-peli");
        } else {
            changeGame.setText("15-peli");
        }

        menubar.add(newGame);
        menubar.add(solve);
        menubar.add(changeGame);

        NewGameButtonListener listener1 = new NewGameButtonListener(this, generator, puzzle.n());
        newGame.addActionListener(listener1);

        SolveButtonListener listener2 = new SolveButtonListener(puzzle, renderer);
        solve.addActionListener(listener2);
        
        ChangeGameButtonListener listener3 = new ChangeGameButtonListener(this, generator, puzzle.n());
        changeGame.addActionListener(listener3);
    }

    private void createComponents(Container container) {
        renderer = new Renderer(puzzle, 100);
        container.add(renderer);
    }

    public JFrame getFrame() {
        return frame;
    }

    /**
     * Metodi päivittää käyttöliittymän vastaamaan metodina annettua pelitilaa.
     *
     * @param puzzle Uusi käytössä oleva pelitila.
     */
    public void update(Puzzle puzzle) {
        this.puzzle = puzzle;
        Container c = frame.getContentPane();
        c.removeAll();
        createComponents(c);

        JMenuBar menu = frame.getJMenuBar();
        menu.removeAll();
        createMenuBar();

        frame.setVisible(true);
    }
}