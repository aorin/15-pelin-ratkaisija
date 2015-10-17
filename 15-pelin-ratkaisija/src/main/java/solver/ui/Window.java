package solver.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.KeyboardFocusManager;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import solver.App;
import solver.logic.dataStructures.List;
import solver.logic.domain.Move;
import solver.logic.domain.Puzzle;
import solver.ui.listeners.menulisteners.ChangeGameButtonListener;
import solver.ui.listeners.menulisteners.GiveGameButtonListener;
import solver.ui.listeners.KeyListener;
import solver.ui.listeners.menulisteners.MoverButtonListener;
import solver.ui.listeners.menulisteners.NewGameButtonListener;
import solver.ui.listeners.menulisteners.SolveButtonListener;
import solver.ui.listeners.TableListener;
import solver.ui.listeners.menulisteners.ChangeHeuristicButtonListener;

/**
 * Luokka luo käyttöliittymäikkunan ja ohjaa sen toimintaa.
 */
public class Window implements Runnable {

    private App app;
    private JFrame frame;
    private JMenuBar menubar;
    private Renderer renderer;
    private Logger logger;
    private JTextArea textArea;
    private KeyListener keyListener;
    private MoverButtonListener moverListener;
    private SolveButtonListener solver;

    /**
     * Konstruktorissa asetetaan käyttöliittymällä käytössä oleva peli
     *
     * @param puzzle Käytössä oleva peliasetelma
     * @param generator Uusien peliasetelmien generaattori
     */
    public Window(App app) {
        this.app = app;
    }

    @Override
    public void run() {
        frame = new JFrame("15-pelin ratkaisija");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createMenuBar();
        createComponents(frame.getContentPane());

        frame.getContentPane().setPreferredSize(new Dimension(app.getN() * 100 + 1, app.getN() * 100 + 21));
        frame.pack();
        frame.setResizable(false);

        centreWindow();
        frame.setVisible(true);
    }

    private void createMenuBar() {
        menubar = new JMenuBar();
        frame.setJMenuBar(menubar);

        JMenuItem newRandom = new JMenuItem("Uusi");
        JMenuItem solve = new JMenuItem("Ratkaise");
        JMenuItem mover = new JMenuItem("Siirtäjä");
        mover.setEnabled(false);

        JMenu others = new JMenu("Muut");
        JMenuItem changeGame = new JMenuItem();
        if (app.getN() == 4) {
            changeGame.setText("8-peli");
        } else {
            changeGame.setText("15-peli");
        }
        JMenuItem heurestic = new JMenuItem("Vaihda heurestiikkaa");
        JMenuItem giveGame = new JMenuItem("Syötä uusi");
        others.add(changeGame);
        others.add(heurestic);
        others.add(giveGame);

        menubar.add(newRandom);
        menubar.add(solve);
        menubar.add(mover);
        menubar.add(others);

        NewGameButtonListener listener1 = new NewGameButtonListener(app);
        newRandom.addActionListener(listener1);

        solver = new SolveButtonListener(app, this);
        solve.addActionListener(solver);

        ChangeGameButtonListener listener3 = new ChangeGameButtonListener(app);
        changeGame.addActionListener(listener3);

        GiveGameButtonListener listener4 = new GiveGameButtonListener(this);
        giveGame.addActionListener(listener4);

        ChangeHeuristicButtonListener listener5 = new ChangeHeuristicButtonListener(solver);
        heurestic.addActionListener(listener5);

        moverListener = new MoverButtonListener(app, this);
        mover.addActionListener(moverListener);
    }

    private void createComponents(Container container) {
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBackground(menubar.getBackground());
        textArea.setPreferredSize(new Dimension(container.getWidth(), 20));
        container.add(textArea, BorderLayout.SOUTH);
        renderer = new Renderer(app.getPuzzle(), 100);
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
    public void update() {
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
            disableButton(i);
        }
    }

    public void disableButton(int i) {
        frame.getJMenuBar().getComponent(i).setEnabled(false);
    }

    public void enableButtonsExceptMover() {
        for (int i = 0; i < 4; i++) {
            if (i != 2) {
                frame.getJMenuBar().getComponent(i).setEnabled(true);
            }
        }
    }

    public void enableAllButtons() {
        for (int i = 0; i < 4; i++) {
            frame.getJMenuBar().getComponent(i).setEnabled(true);
        }
    }

    public void addKeyListener(List<Move> moves) {
        keyListener = new KeyListener(this, app.getPuzzle(), moves);
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

    public void changeToInputMode() {
        int n = app.getN();
        disableButton(1);
        disableButton(2);

        String[][] values = new String[n][n];
        String[] names = new String[n];
        for (int i = 0; i < values.length; i++) {
            names[i] = "";
            for (int j = 0; j < values.length; j++) {
                values[i][j] = "";
            }
        }
        JTable table = new JTable(values, names);
        table.setRowHeight(n * 100 / n);
        table.getModel().addTableModelListener(new TableListener(app, table));

        frame.getContentPane().remove(renderer);
        frame.getContentPane().add(table, BorderLayout.CENTER);
        frame.revalidate();
    }
}
