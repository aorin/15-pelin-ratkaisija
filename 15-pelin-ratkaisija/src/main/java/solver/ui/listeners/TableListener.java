package solver.ui.listeners;

import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import solver.App;
import solver.logic.dataStructures.List;
import solver.logic.domain.Puzzle;

/**
 * Luokka tulkitsee taulukkoon tehtyjä muutoksia.
 */
public class TableListener implements TableModelListener {

    private App app;
    private JTable table;
    private int n;
    private int[][] values;

    /**
     * Konstruktori luo uuden taulukonkuuntelijan.
     *
     * @param app Käytössä oleva ohjelma
     * @param table Taulukko, jota kuunnellaan
     */
    public TableListener(App app, JTable table) {
        this.app = app;
        this.table = table;
        this.n = table.getColumnCount();
        this.values = new int[n][n];
    }

    @Override
    public void tableChanged(TableModelEvent tme) {
        for (int i = tme.getFirstRow(); i <= tme.getLastRow(); i++) {
            try {
                values[tme.getColumn()][i] = Integer.parseInt(table.getValueAt(i, tme.getColumn()).toString());
                if (hasAllValues()) {
                    app.changePuzzle(new Puzzle(values));
                }
            } catch (Exception e) {
            }
        }
    }

    private boolean hasAllValues() {
        List list = new List();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (list.contains(values[i][j])) {
                    return false;
                }
                if (values[i][j] < 0 || values[i][j] >= n * n) {
                    return false;
                }
                list.add(values[i][j]);
            }
        }

        return true;
    }
}
