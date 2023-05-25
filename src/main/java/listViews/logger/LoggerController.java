package listViews.logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created: 25.05.2023 at 20:31
 *
 * @author Plasek Sebastian
 */
public class LoggerController implements Initializable {

    @FXML
    private ListView<String> listView;

    @FXML
    private ToggleGroup tg;

    @FXML
    void handleButtonAction(ActionEvent event) {
        listView.getItems().add(new LogEntry(((Button) event.getSource()).getText()).makeText() + " clicked");
        scroll();
    }

    @FXML
    void handleCheckAction(ActionEvent event) {
        if (((CheckBox) event.getSource()).isSelected()) {
            listView.getItems().add(new LogEntry(((CheckBox) event.getSource()).getText()).makeText() + " checked");
        } else {
            listView.getItems().add(new LogEntry(((CheckBox) event.getSource()).getText()).makeText() + " un-checked");
        }
        scroll();
    }

    @FXML
    void handleRadioAction(ActionEvent event) {
        listView.getItems().add(new LogEntry(((RadioButton) event.getSource()).getText()).makeText() + " selected");
        scroll();
    }

    private void scroll() {
        this.listView.scrollTo(this.listView.getItems().size());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
