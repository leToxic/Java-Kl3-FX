package listViews;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.testfx.api.FxRobot;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public abstract class FxTest {
    private static final int ERROR_FXML_NOT_FOUND = 1;
    private static final int ERROR_ID_NOT_FOUND = 2;
    private Parent root;

    @BeforeAll
    static void setFailOnError() {
        Thread.setDefaultUncaughtExceptionHandler((t, error) -> fail(error));
    }

    @AfterEach
    void closeDialogs(FxRobot robot) {
        List<Window> windows = robot.listWindows();
        if (windows.size() > 1) {
            for (int i = 1; i < windows.size(); i++) {
                Stage stage = (Stage) windows.get(i);
                prepareDialogForClosing(robot, stage);
                robot.interact(stage::close);
            }
        }
    }

    void prepareDialogForClosing(FxRobot robot, Stage stage) {
        Node root = robot.rootNode(stage);
        if (!(root instanceof DialogPane))
            return;
        DialogPane dialogPane = (DialogPane) root;
        robot.interact(() -> dialogPane.getButtonTypes().add(ButtonType.CANCEL));
    }

    protected void startApplication(Stage primaryStage, String pathToFxml) throws IOException {
        URL fxml = getClass().getResource(pathToFxml);
        assertFxmlExists(fxml, pathToFxml);
        root = FXMLLoader.load(fxml);
        primaryStage.setScene(new Scene((root)));
        primaryStage.show();
    }

    void assertFxmlExists(URL fxml, String pathToFxml) {
        if (fxml == null) {
            System.err.println("Fxml not found: " + pathToFxml);
            System.exit(ERROR_FXML_NOT_FOUND);
        }
    }

    @SuppressWarnings("unchecked")
    protected <T> T getById(String id) {
        Node requested = root.lookup('#' + id);
        if (requested == null) {
            System.err.println("FxId not found: " + id);
            System.exit(ERROR_ID_NOT_FOUND);
        }
        return (T) requested;
    }
}
