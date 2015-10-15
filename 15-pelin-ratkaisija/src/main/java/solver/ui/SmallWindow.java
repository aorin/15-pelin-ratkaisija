package solver.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class SmallWindow implements Runnable {
    private JFrame frame;
    private int n;

    public SmallWindow(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        frame = new JFrame("15-pelin ratkaisija");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.getContentPane().setPreferredSize(new Dimension(50 * n, 50 * n));

        frame.pack();
        frame.setResizable(false);

        centreWindow();
        frame.setVisible(true);
    }
    
    private void createComponents(Container c) {
        JTextArea textArea = new JTextArea(n, n);
        c.add(textArea);
    }

    private void centreWindow() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
}
