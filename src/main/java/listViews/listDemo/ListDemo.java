package listViews.listDemo;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created: 25.05.2023 at 12:50
 *
 * @author Plasek Sebastian
 */
public class ListDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(ListDemo.class.getResource("/listViews/listDemo/ListView.fxml"));
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("ListDemo");
        stage.show();
    }
}
