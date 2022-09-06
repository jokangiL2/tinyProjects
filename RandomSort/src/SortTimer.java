import java.util.ArrayList;
import java.util.Random;

public final class SortTimer {
    private static int MAX = 100;
    private static int MIN = 100;
    private static int DATA_COUNT = 10;

    private SortTimer() {
    }

    private static ArrayList<Integer> generateData(int elementCount) {
        ArrayList<Integer> list = new ArrayList<>();
        var rand = new Random();

        for (int i = 0; i < elementCount; i++) {
            list.add(rand.nextInt(MAX + MIN) - MIN); // generate random int between MIN ~ MAX.
        }

        return list;
    }

    public static void printRecordTime(Sortable sortable) {
        var start = System.currentTimeMillis();
        sortable.sort(generateData(DATA_COUNT));
        var end = System.currentTimeMillis();

        System.out.println(end - start);

    }
}
