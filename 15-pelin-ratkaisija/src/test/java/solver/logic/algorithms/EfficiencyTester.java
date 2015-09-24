package solver.logic.algorithms;

import org.junit.Test;

public class EfficiencyTester {
    private IDAStarEfficiencyTester idastarTester;

    public EfficiencyTester() {
        this.idastarTester = new IDAStarEfficiencyTester();
    }
    
    @Test
    public void testIDASTar() {
        double under41 = idastarTester.test15PuzzlesUnder40Moves(100);
        System.out.println("Alle 41 siirron peleihin kului aikaa " + under41 + " ms.");
    }
}
