package solver.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import solver.logic.domain.Puzzle;

/**
 * Luokka sisältää toiminnallisuuden numeroiden piirtämiseen näytölle.
 */
public class Renderer extends JPanel {
    private Puzzle puzzle;
    private int sideLenght;
    private int n;
    
    /**
     * Konstruktorissa piirtäjälle annetaan käytetty pelilauta ja haluttu yhden ruudun leveys.
     * @param puzzle Käytössä oleva peli
     * @param sideLenght Ruudun leveys
     */
    public Renderer (Puzzle puzzle, int sideLenght) {
        this.puzzle = puzzle;
        this.sideLenght = sideLenght;
        this.n = puzzle.n();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        int x = 0, y = 0;
        
        for (int i = 0; i < n; i++) {
            y = 0;
            for (int j = 0; j < n; j++) {
                g.drawString("" + puzzle.valueAtPoint(i, j), x  + sideLenght / 2, y  + sideLenght / 2);
                g.drawRect(x, y, sideLenght, sideLenght);
                if (puzzle.valueAtPoint(i, j) == 0) {
                    g.fillRect(x, y, sideLenght, sideLenght);
                }
                y += sideLenght;
            }
            x += sideLenght;
        }
    }
}
