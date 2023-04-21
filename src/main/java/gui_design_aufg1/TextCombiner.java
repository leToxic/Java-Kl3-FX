package gui_design;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created: 20.04.2023 at 11:58
 *
 * @author Plasek Sebastian
 */
public class TextCombiner extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/gui_design/TextCombiner.fxml"));

        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.setTitle("Text Combiner");
        primaryStage.show();
    }
}
