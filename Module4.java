import java.util.LinkedList;
import java.util.Iterator;

public class Module4 {

    public static LinkedList<Integer> createList(int numberOfElements) {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < numberOfElements; i++) {
            list.add(i);
        }

        return list;
    }

    public static long measureIteratorTime(LinkedList<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        long startTime = System.nanoTime();

        while (iterator.hasNext()) {
            int value = iterator.next(); 
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static long measureGetTime(LinkedList<Integer> list) {
        long startTime = System.nanoTime();

        for (int i = 0; i < list.size(); i++) {
            int value = list.get(i); 
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    // This method runs both tests for a given list size and prints the results
    public static void runTest(int size) {
        System.out.println("\n--- Testing with " + size + " elements ---");

        LinkedList<Integer> testList = createList(size);

        // Measure and print 
        long timeUsingIterator = measureIteratorTime(testList);
        System.out.println("Time using Iterator: " + timeUsingIterator / 1_000_000.0 + " ms");

        long timeUsingGet = measureGetTime(testList);
        System.out.println("Time using get(index): " + timeUsingGet / 1_000_000.0 + " ms");
    }

    // Main method runs the program and test
    public static void main(String[] args) {
        runTest(50_000);    
        runTest(500_000);   
    }
}
