package solver.logic.efficiencyTests;

import org.junit.Test;

public class EfficiencyTester {

    private IDAStarEfficiencyTest idastarTest;
    private ListEfficiencyTest listTest;

    public EfficiencyTester() {
        this.idastarTest = new IDAStarEfficiencyTest();
        this.listTest = new ListEfficiencyTest();
    }
    
    @Test
    public void testIDAStar15() {
        System.out.println("");
        System.out.println("IDAStarin suorituskykytestaus");
        System.out.println("");
        
        for (int i = 40; i <= 60; i += 5) {
//            System.out.println(i + " kokoiseen 15-pelin ratkaisemiseen kului aikaa " + idastarTest.test15Puzzle(10, i) + " ns.");
        }
        
        System.out.println("");
    }

    @Test
    public void testIDASTarRandom15() {
//        long under56 = idastarTest.testRandom15Puzzles(1, 55);
//        long under61 = idastarTest.testRandom15Puzzles(1, 60);
//        
//        System.out.println("");
//        System.out.println("Satunnaisten pelien ratkaisemiseen kuluva aika (15-peli):");
//        System.out.println("55 ja alle siirtoa: " + under56 + " ns.");
//        System.out.println("60 ja alle siirtoa: " + under61 + " ns.");
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
