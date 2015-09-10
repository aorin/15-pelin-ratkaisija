package solver.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import solver.logic.domain.State;

public class Renderer extends JPanel {
    private State gameState;
    private int sideLenght;
    
    public Renderer (State gameState, int sideLenght) {
        this.gameState = gameState;
        this.sideLenght = sideLenght;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        int x = 0, y = 0;
        
        for (int i = 0; i < 4; i++) {
            y = 0;
            for (int j = 0; j < 4; j++) {
                g.drawString("" + gameState.valueAtPoint(i, j), x  + sideLenght / 2, y  + sideLenght / 2);
                g.drawRect(x, y, sideLenght, sideLenght);
                if (gameState.valueAtPoint(i, j) == 0) {
                    g.fillRect(x, y, sideLenght, sideLenght);
                }
                y += sideLenght;
            }
            x += sideLenght;
        }
    }
}
