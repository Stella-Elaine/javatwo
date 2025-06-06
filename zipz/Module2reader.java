import java.io.*;

public class Module2Reader {
    public static void main(String[] args) {
        String filename = "Skempdatafile.dat"; 

        try {
            FileInputStream fis = new FileInputStream(filename);
            DataInputStream dis = new DataInputStream(fis);

            while (true) {
                try {
                    String label = dis.readUTF();
                    System.out.println(label);

                    if (label.equals("INTEGERS:")) {
                        for (int i = 0; i < 5; i++) {
                            int num = dis.readInt();
                            System.out.println("Integer: " + num);
                        }
                    } else if (label.equals("DOUBLES:")) {
                        for (int i = 0; i < 5; i++) {
                            double d = dis.readDouble();
                            System.out.printf("Double: %.2f%n", d);
                        }
                    }
                } catch (EOFException end) {
                    break; 
                }
            }

            dis.close();
            System.out.println("\n Done reading from " + filename);

        } catch (IOException e) {
            System.out.println(" Problem finding the file: " + e.getMessage());
        }
    }
}
