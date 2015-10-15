package solver.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.KeyboardFocusManager;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import solver.logic.dataStructures.List;
import solver.logic.domain.Move;
import solver.logic.domain.Puzzle;
import solver.logic.util.GameboardGenerator;
import solver.ui.listeners.ChangeGameButtonListener;
import solver.ui.listeners.KeyListener;
import solver.ui.listeners.MoverButtonListener;
import solver.ui.listeners.NewGameButtonListener;
import solver.ui.listeners.SolveButtonListener;

/**
 * Luokka luo käyttöliittymäikkunan ja ohjaa sen toimintaa.
 */
public class Window implements Runnable {

    private GameboardGenerator generator;
    private JFrame frame;
    private Puzzle puzzle;
    private JMenuBar menubar;
    private Renderer renderer;
    private Logger logger;
    private JTextArea textArea;
    private KeyListener keyListener;
    private MoverButtonListener moverListener;

    /**
     * Konstruktorissa asetetaan käyttöliittymällä käytössä oleva peli
     *
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

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createMenuBar();
        createComponents(frame.getContentPane());

        frame.getContentPane().setPreferredSize(new Dimension(puzzle.n() * 100 + 1, puzzle.n() * 100 + 21));

        frame.pack();
        frame.setResizable(false);

        centreWindow();
        frame.setVisible(true);
    }

    private void createMenuBar() {
        menubar = new JMenuBar();
        frame.setJMenuBar(menubar);

        JMenuItem newGame = new JMenuItem("Uusi");
        JMenuItem solve = new JMenuItem("Ratkaise");
        JMenuItem changeGame = new JMenuItem();
//        JMenuItem giveGame = new JMenuItem("Syötä uusi");

        JMenuItem mover = new JMenuItem("Siirtäjä");
        mover.setEnabled(false);

        if (puzzle.values().length == 4) {
            changeGame.setText("8-peli");
        } else {
            changeGame.setText("15-peli");
        }

        menubar.add(newGame);
        menubar.add(solve);
        menubar.add(changeGame);
        menubar.add(mover);
//        menubar.add(giveGame);

        NewGameButtonListener listener1 = new NewGameButtonListener(this, generator, puzzle.n());
        newGame.addActionListener(listener1);

        SolveButtonListener listener2 = new SolveButtonListener(this, puzzle);
        solve.addActionListener(listener2);

        ChangeGameButtonListener listener3 = new ChangeGameButtonListener(this, generator, puzzle.n());
        changeGame.addActionListener(listener3);

//        GiveGameButtonListener listener4 = new GiveGameButtonListener(puzzle);
//        giveGame.addActionListener(listener4);
        moverListener = new MoverButtonListener(this, puzzle);
        mover.addActionListener(moverListener);
    }

    private void createComponents(Container container) {
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBackground(menubar.getBackground());
        textArea.setPreferredSize(new Dimension(container.getWidth(), 20));
        container.add(textArea, BorderLayout.SOUTH);
        renderer = new Renderer(puzzle, 100);
        container.add(renderer, BorderLayout.CENTER);

        logger = new Logger(textArea);
    }

    public Renderer getRenderer() {
        return renderer;
    }

    /**
     * Metodi päivittää käyttöliittymän vastaamaan metodina annettua pelitilaa.
     *
     * @param puzzle Uusi käytössä oleva pelitila.
     */
    public void update(Puzzle puzzle) {
        this.puzzle = puzzle;

        JMenuBar menu = frame.getJMenuBar();
        menu.removeAll();
        createMenuBar();

        Container c = frame.getContentPane();
        c.removeAll();
        createComponents(c);

        frame.setVisible(true);
    }

    public void close() {
        frame.dispose();
    }

    public void alert(String text) {
        logger.log(text);
    }

    public void disableButtons() {
        for (int i = 0; i < 4; i++) {
            frame.getJMenuBar().getComponent(i).setEnabled(false);
        }
    }

    public void enableButtons() {
        for (int i = 0; i < 3; i++) {
            frame.getJMenuBar().getComponent(i).setEnabled(true);
        }
    }

    public void enableAllButtons() {
        for (int i = 0; i < 4; i++) {
            frame.getJMenuBar().getComponent(i).setEnabled(true);
        }
    }

    public void addKeyListener(List<Move> moves) {
        keyListener = new KeyListener(this, puzzle, moves);
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(keyListener);
        frame.getJMenuBar().getComponent(3).setEnabled(true);
        moverListener.setMoves(moves);
    }

    public KeyListener getKeyListener() {
        return keyListener;
    }

    private void centreWindow() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
}
