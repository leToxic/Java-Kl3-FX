package listViews.numberList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import listViews.listDemo.ListDemo;

/**
 * Created: 25.05.2023 at 14:55
 *
 * @author Plasek Sebastian
 */
public class NumberList extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(ListDemo.class.getResource("/listViews/numberList/NumberList.fxml"));
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("NumberList");
        stage.show();
    }
}
