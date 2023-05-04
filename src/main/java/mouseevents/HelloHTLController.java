package mouseevents;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created: 04.05.2023 at 11:38
 *
 * @author Plasek Sebastian
 */
public class HelloHTLController implements Initializable {

    @FXML
    private StackPane pane;

    @FXML
    void rotate(MouseEvent event) {
        rt.play();
    }

    RotateTransition rt;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.rt = new RotateTransition();
        this.rt.setNode(pane);
        rt.setFromAngle(0);
        rt.setToAngle(180);

        rt.setDuration(Duration.millis(2000));
        rt.setAutoReverse(true);
        rt.setCycleCount(2);
    }
}
