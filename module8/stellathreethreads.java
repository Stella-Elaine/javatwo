import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class StellaThreeThreads extends Application {

    private static final int COUNT = 10000;

    private TextArea textArea = new TextArea();

    @Override
    public void start(Stage primaryStage) {
        textArea.setWrapText(true);
        textArea.setEditable(false);

        VBox root = new VBox(textArea);
        Scene scene = new Scene(root, 600, 400);

        new Thread(this::generateLetters).start();
        new Thread(this::generateDigits).start();
        new Thread(this::generateSymbols).start();

        primaryStage.setTitle("Three Threads Output");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void generateLetters() {
        Random rand = new Random();
        for (int i = 0; i < COUNT; i++) {
            char letter = (char) ('a' + rand.nextInt(26));
            appendToTextArea(letter);
        }
    }
    private void generateDigits() {
        Random rand = new Random();
        for (int i = 0; i < COUNT; i++) {
            char digit = (char) ('0' + rand.nextInt(10));
            appendToTextArea(digit);
        }
    }

    private void generateSymbols() {
        char[] symbols = {'!', '@', '#', '$', '%', '&', '*'};
        Random rand = new Random();
        for (int i = 0; i < COUNT; i++) {
            char symbol = symbols[rand.nextInt(symbols.length)];
            appendToTextArea(symbol);
        }
    }

    private void appendToTextArea(char c) {
        javafx.application.Platform.runLater(() -> textArea.appendText(String.valueOf(c)));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
