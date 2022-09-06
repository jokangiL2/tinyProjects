import java.util.ArrayList;
import java.util.Random;

public final class Sort implements Sortable {
    private static Sort instance;

    private Sort() {
    }

    public static Sort getInstance() {
        return (instance == null) ? new Sort() : instance;
    }

    private static boolean isSorted(ArrayList<Integer> list) { // 오름차순.
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) > list.get(i)) {
                return false;
            }
        }

        return true;
    }

    // need more test.
    public void RandomSort(ArrayList<Integer> list) {
        int callCount = 0;
        var rand = new Random();

        while (!isSorted(list)) {
            System.out.println(++callCount);

            for (int i = 0; i < list.size(); i++) {
                int index = rand.nextInt(list.size());

                int temp = list.get(i);
                list.set(i, list.get(index));
                list.set(index, temp);
            }
        }
    }

    @Override
    public void sort(ArrayList<Integer> list) {
        RandomSort(list);
    }
}
