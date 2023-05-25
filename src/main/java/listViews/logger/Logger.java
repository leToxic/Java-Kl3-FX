package listViews.logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import listViews.listDemo.ListDemo;

import java.io.IOException;

/**
 * Created: 25.05.2023 at 20:31
 *
 * @author Plasek Sebastian
 */
public class Logger extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(ListDemo.class.getResource("/listViews/logger/Logger.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.setTitle("Logger");
        primaryStage.show();
    }
}
