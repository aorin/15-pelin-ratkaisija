package solver.logic.efficiencyTests;

import org.junit.Test;

public class EfficiencyTester {

    private IDAStarEfficiencyTest idastarTest;
    private SolvabilityDeterminerEfficiencyTest solvabilityDeterminerTest;
    private ListEfficiencyTest listTest;

    public EfficiencyTester() {
        this.idastarTest = new IDAStarEfficiencyTest();
        this.solvabilityDeterminerTest = new SolvabilityDeterminerEfficiencyTest();
        this.listTest = new ListEfficiencyTest();
    }

    @Test
    public void testIDAStar() {
        System.out.println("");
        System.out.println("IDAStarin suorituskykytestaus");
        System.out.println("");

//        for (int i = 40; i <= 60; i += 5) {
//            System.out.println(i + " kokoiseen 15-pelin ratkaisemiseen kului aikaa " + (idastarTest.test15PuzzleManhattan(10, i) / 1000000.0 / 1000) + " s.");
//            System.out.println("Konfliktit mukaan huomioituna " + (idastarTest.test15PuzzleManhattanWithConflicts(10, i) / 1000000.0 / 1000) + " s.");
//            System.out.println("");
//        }
        for (int i = 16; i <= 26; i += 2) {
            System.out.println(i + " kokoiseen 8-pelin ratkaisemiseen kului aikaa " + (idastarTest.test8PuzzleManhattan(10000, i) / 1000000.0) + " ms.");
            System.out.println("Konfliktit mukaan huomioituna " + (idastarTest.test8PuzzleManhattanWithConflicts(10000, i) / 1000000.0) + " ms.");
            System.out.println("");
        }

        System.out.println("");
    }

    @Test
    public void testSolvabilityDeterminer() {
        System.out.println("");
        System.out.println("Ratkaistavuuden selvittämisen testaus");
        System.out.println("");
        System.out.println("8-pelin ratkaistavuus selvitettään keskimäärin ajassa " + (solvabilityDeterminerTest.test8Puzzle(1000) / 1000000.0) + " ms.");
        System.out.println("15-pelin ratkaistavuus selvitettään keskimäärin ajassa " + (solvabilityDeterminerTest.test15Puzzle(1000) / 1000000.0) + " ms.");
        System.out.println("");
    }

    @Test
    public void compareLists() {
        long[] add1 = listTest.add(1, 100);
        long[] add100 = listTest.add(100, 100);
        long[] add200 = listTest.add(200, 100);
        long[] clear = listTest.clear(100, 100);
        long[] get = listTest.get(100, 100);
        long[] contains = listTest.contains(100, 100);

        System.out.println("");
        System.out.println("Listojen vertailu:");
        System.out.println("");
        System.out.println("Yhden lisäys");
        System.out.println("List: " + add1[0] + "ns, ArrayList: " + add1[1] + "ns");
        System.out.println("Sadan lisäys");
        System.out.println("List: " + add100[0] + "ns, ArrayList: " + add100[1] + "ns");
        System.out.println("Kahdensadan lisäys");
        System.out.println("List: " + add200[0] + "ns, ArrayList: " + add200[1] + "ns");
        System.out.println("Tyhjennys");
        System.out.println("List: " + clear[0] + "ns, ArrayList: " + clear[1] + "ns");
        System.out.println("Haku");
        System.out.println("List: " + get[0] + "ns, ArrayList: " + get[1] + "ns");
        System.out.println("Sisältää");
        System.out.println("List: " + contains[0] + "ns, ArrayList: " + contains[1] + "ns");
        System.out.println("");
    }
}
