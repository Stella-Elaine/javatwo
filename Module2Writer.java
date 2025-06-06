import java.io.*;
import java.util.Random;

public class Module2Writer {
    public static void main(String[] args) {
        String filename = "Skempdatafile.dat"; 
        Random rand = new Random();

        int[] numbers = new int[5];
        double[] decimals = new double[5];

        for (int i = 0; i < 5; i++) {
            numbers[i] = rand.nextInt(101);       
            decimals[i] = rand.nextDouble() * 100; 
        }

        try {
            FileOutputStream fos = new FileOutputStream(filename, true); 
            DataOutputStream dos = new DataOutputStream(fos);

            dos.writeUTF("--- New Data Set ---");

            dos.writeUTF("INTEGERS:");
            for (int num : numbers) {
                dos.writeInt(num);
                System.out.println("Saved integer: " + num);
            }

            dos.writeUTF("DOUBLES:");
            for (double d : decimals) {
                dos.writeDouble(d);
                System.out.printf("Saved double: %.2f%n", d);
            }

            dos.close();
            System.out.println(" Done writing to " + filename + "\n");

        } catch (IOException e) {
            System.out.println(" Error writing file: " + e.getMessage());
        }
    }
}
