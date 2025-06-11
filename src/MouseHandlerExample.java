import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MouseHandlerExample extends Application {

    @Override
    public void start(Stage stage) {
        // Create a Button
        Button button = new Button("Hover or Click Me");

        // Set Mouse Event Handlers
        button.setOnMousePressed(event -> {
            System.out.println("Mouse pressed on the button!");
        });

        button.setOnMouseReleased(event -> {
            System.out.println("Mouse released on the button!");
        });

        button.setOnMouseEntered(event -> {
            System.out.println("Mouse entered the button area!");
        });

        button.setOnMouseExited(event -> {
            System.out.println("Mouse exited the button area!");
        });

        // Add button to layout
        VBox root = new VBox(button);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        // Set up Scene and Stage
        Scene scene = new Scene(root, 300, 200);
        stage.setTitle("MouseHandler Example");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
