import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Module_3 {

    public static void main(String[] args) {
        ArrayList<Integer> originalList = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 50; i++) {
            originalList.add(rand.nextInt(20) + 1);
        }

        System.out.println("First List:");
        System.out.println(firstList);

        ArrayList<Integer> noDuplicates = removeDuplicates(firstList);

        System.out.println("\nLupdated list:");
        System.out.println(noDuplicates);
    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        return new ArrayList<>(new HashSet<>(list));
    }
}
