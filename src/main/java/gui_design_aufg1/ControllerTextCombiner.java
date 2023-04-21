package gui_design_aufg1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created: 20.04.2023 at 11:50
 *
 * @author Plasek Sebastian
 */
public class ControllerTextCombiner implements Initializable {

    @FXML
    private RadioButton case1;

    @FXML
    private RadioButton case2;

    @FXML
    private ToggleGroup mGroup;

    @FXML
    private TextField sendText;

    @FXML
    private TextField text1;

    @FXML
    private TextField text2;

    @FXML
    void handleClearAction(ActionEvent event) {
        text1.setText("");
        text2.setText("");
        sendText.setText("");
        case1.setSelected(true);
        case2.setSelected(false);
    }

    @FXML
    void handleSendTextAction(ActionEvent event) {
        this.sendText.setText("");
        if (text1.getText().isBlank() || text2.getText().isBlank()) {
            sendText.setText("Einer der beiden Werte nicht gesetzt. Bitte machen!");
        } else if (this.case1.isSelected()) {
            sendText.setText(text1.getText() + " " + text2.getText());
        } else if (this.case2.isSelected()) {
            sendText.setText(text2.getText() + " " + text1.getText());
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // not TODO
    }
}

