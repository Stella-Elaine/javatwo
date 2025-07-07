import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ColorCircle extends Application {

    @Override
    public void start(Stage primaryStage) {
        Circle redCircle = new Circle(50);
        redCircle.setId("redcircle");

        Circle plainCircle = new Circle(50);
        plainCircle.getStyleClass().add("plaincircle");

        Circle dashedCircle = new Circle(50);
        dashedCircle.getStyleClass().addAll("plaincircle", "circleborder");

        Circle greenCircle = new Circle(50);
        greenCircle.setId("greencircle");

        HBox hbox = new HBox(20, redCircle, plainCircle, dashedCircle, greenCircle);
        hbox.setStyle("-fx-padding: 20; -fx-alignment: center; -fx-background-color: lightgray;");

        Scene scene = new Scene(hbox, 600, 200);
        scene.getStylesheets().add("mystyle.css");

        primaryStage.setTitle("Simple Styled Circles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
