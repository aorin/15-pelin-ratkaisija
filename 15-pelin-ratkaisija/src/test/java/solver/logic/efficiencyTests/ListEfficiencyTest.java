package solver.logic.efficiencyTests;

import java.util.ArrayList;
import java.util.Random;
import solver.logic.dataStructures.List;

public class ListEfficiencyTest {

    private List<Integer> list;
    private ArrayList<Integer> arrayList;
    private Random random;

    public ListEfficiencyTest() {
        this.list = new List<>();
        this.arrayList = new ArrayList<>();
        this.random = new Random();
    }

    public long[] add(int n, int t) {
        long[] result = new long[2];

        for (int i = 0; i < t; i++) {
            long[] r = add(n);
            result[0] += r[0];
            result[1] += r[1];
            clear();
        }

        result[0] /= (long) t;
        result[1] /= (long) t;

        return result;
    }

    private long[] add(int n) {
        long[] result = new long[2];
        long start, end;

        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        end = System.nanoTime();

        result[0] = end - start;

        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            arrayList.add(i);
        }
        end = System.nanoTime();

        result[1] = end - start;

        return result;
    }

    public long[] clear(int n, int t) {
        long[] result = new long[2];

        for (int i = 0; i < t; i++) {
            add(n);
            long[] r = clear();
            result[0] += r[0];
            result[1] += r[1];
        }

        result[0] /= t;
        result[1] /= t;

        return result;
    }

    private long[] clear() {
        long[] result = new long[2];
        long start, end;

        start = System.nanoTime();
        list.clear();
        end = System.nanoTime();

        result[0] = end - start;

        start = System.nanoTime();
        arrayList.clear();
        end = System.nanoTime();

        result[1] = end - start;

        return result;
    }

    public long[] get(int n, int t) {
        long[] result = new long[2];
        add(n);

        for (int i = 0; i < t; i++) {
            long[] r = get(n);
            result[0] += r[0];
            result[1] += r[1];
        }

        clear();
        result[0] /= t;
        result[1] /= t;

        return result;
    }

    private long[] get(int n) {
        long[] result = new long[2];
        long start, end;
        int index = random.nextInt(n);

        start = System.nanoTime();
        list.get(index);
        end = System.nanoTime();

        result[0] = end - start;

        start = System.nanoTime();
        arrayList.get(index);
        end = System.nanoTime();

        result[1] = end - start;

        return result;
    }

    public long[] contains(int n, int t) {
        long[] result = new long[2];
        add(n);

        for (int i = 0; i < t; i++) {
            long[] r = contains(n);
            result[0] += r[0];
            result[1] += r[1];
        }

        clear();
        result[0] /= t;
        result[1] /= t;
        return result;
    }

    private long[] contains(int n) {
        long[] result = new long[2];
        long start, end;
        int number = random.nextInt(n);

        start = System.nanoTime();
        list.contains(number);
        end = System.nanoTime();

        result[0] = end - start;

        start = System.nanoTime();
        arrayList.contains(number);
        end = System.nanoTime();

        result[1] = end - start;

        return result;
    }
}
