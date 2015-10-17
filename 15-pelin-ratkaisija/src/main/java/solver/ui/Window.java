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
import solver.ui.listeners.menulisteners.ChangeGameButtonListener;
import solver.ui.listeners.menulisteners.GiveGameButtonListener;
import solver.ui.listeners.menulisteners.MoverButtonListener;
import solver.ui.listeners.menulisteners.NewGameButtonListener;
import solver.ui.listeners.menulisteners.SolveButtonListener;
import solver.ui.listeners.menulisteners.ChangeHeuristicButtonListener;
import solver.ui.listeners.KeyListener;
import solver.ui.listeners.TableListener;

/**
 * Luokka luo käyttöliittymäikkunan ja ohjaa sen toimintaa.
 */
public class Window implements Runnable {

    private App app;
    private JFrame frame;
    private JMenuBar menubar;
    private Renderer renderer;
    private Logger logger;
    private KeyListener keyListener;
    private MoverButtonListener moverListener;
    
    private int tileLenght = 100;

    /**
     * Konstruktorissa asetetaan käyttöliittymällä käytössä oleva ohjelma
     *
     * @param app 15-pelin-ratkaisija-ohjelma
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

        frame.getContentPane().setPreferredSize(new Dimension(app.getN() * tileLenght + 1, app.getN() * tileLenght + 21));
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

        menubar.add(newGame);
        menubar.add(solve);
        menubar.add(mover);
        menubar.add(others);

        newGame.addActionListener(new NewGameButtonListener(app));
        solve.addActionListener(new SolveButtonListener(app, this));
        changeGame.addActionListener(new ChangeGameButtonListener(app));
        giveGame.addActionListener(new GiveGameButtonListener(this));
        heurestic.addActionListener(new ChangeHeuristicButtonListener(app, this));

        moverListener = new MoverButtonListener(app, this);
        mover.addActionListener(moverListener);
    }

    private void createComponents(Container container) {
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBackground(menubar.getBackground());
        textArea.setPreferredSize(new Dimension(container.getWidth(), 20));
        container.add(textArea, BorderLayout.SOUTH);
        renderer = new Renderer(app.getPuzzle(), 100);
        container.add(renderer, BorderLayout.CENTER);

        logger = new Logger(textArea);
    }

    /**
     * Metodi palauttaa käytössä olevan piirtäjän.
     * 
     * @return Piirtäjä 
     */
    public Renderer getRenderer() {
        return renderer;
    }

    /**
     * Metodi päivittää käyttöliittymäikkunan vastaamaan ohjelmaa.
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

    /**
     * Metodi sulkee ikkunan.
     */
    public void close() {
        frame.dispose();
    }

    /**
     * Metodi ilmoittaa käyttäjälle halutun tekstin.
     * 
     * @param text Teksti, joka näytetään käyttäjälle 
     */
    public void alert(String text) {
        logger.log(text);
    }

    /**
     * Metodi poistaa kaikki valikkonapit käytöstä.
     */
    public void disableButtons() {
        for (int i = 0; i < 4; i++) {
            disableButton(i);
        }
    }

    /**
     * Metodi poistaa halutun valikkonapin käytöstä.
     * 
     * @param i Poistettavan valikkonapin indeksi
     */
    public void disableButton(int i) {
        frame.getJMenuBar().getComponent(i).setEnabled(false);
    }

    /**
     * Metodi laittaa kaikki valikkonapit käytettäviksi.
     */
    public void enableButtons() {
        for (int i = 0; i < 4; i++) {
            enableButton(i);
        }
    }

    /**
     * Metodi laittaa halutun valikkonapin käytettäväksi.
     * 
     * @param i Valikonapin indeksi, joka halutaan laittaa käytettäväksi
     */
    public void enableButton(int i) {
        frame.getJMenuBar().getComponent(i).setEnabled(true);
    }

    /**
     * Metodi lisää näppäimistönkuuntelijan.
     */
    public void addKeyListener() {
        keyListener = new KeyListener(app, this);
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(keyListener);
    }

    /**
     * Metodi palauttaa näppäimistönkuuntelijan.
     * 
     * @return Näppäimistönkuuntelija
     */
    public KeyListener getKeyListener() {
        return keyListener;
    }

    /**
     * Metodi vaihtaa näkymän syötetilaan.
     */
    public void changeToInputMode() {
        disableButton(1);
        disableButton(2);

        frame.getContentPane().remove(renderer);
        frame.getContentPane().add(getEmptyTable(app.getN()), BorderLayout.CENTER);
        frame.revalidate();
    }

    private JTable getEmptyTable(int n) {
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
        return table;
    }

    private void centreWindow() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
}
