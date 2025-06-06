import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.Collections;
import java.util.ArrayList;

public class SimpleCardViewer extends Application {

    HBox cardBox = new HBox(10); 

    @Override
    public void start(Stage stage) {
        Button refreshButton = new Button("Refresh");

        refreshButton.setOnAction(event -> showCards());

         BorderPane layout = new BorderPane();
        layout.setCenter(cardBox);
        layout.setBottom(refreshButton);

        Scene scene = new Scene(layout, 400, 300);
        stage.setTitle("Card Viewer");
        stage.setScene(scene);
        stage.show();

        showCards();
    }

    private void showCards() {
        cardBox.getChildren().clear(); 

        ArrayList<Integer> cardNumbers = new ArrayList<>();
        for (int i = 1; i <= 52; i++) {
            cardNumbers.add(i);
        }

        Collections.shuffle(cardNumbers);

        for (int i = 0; i < 4; i++) {
            String filename = "AssignmentCards/" + cardNumbers.get(i) + ".png";
            Image image = new Image(new File(filename).toURI().toString());
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(150);
            imageView.setPreserveRatio(true);
            cardBox.getChildren().add(imageView);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
