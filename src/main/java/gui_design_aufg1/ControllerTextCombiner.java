package gui_design;

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
        this.text1.setText("");
        this.text2.setText("");
        this.sendText.setText("");

        this.case1.setSelected(true);
        this.case2.setSelected(false);
    }

    @FXML
    void handleSendTextAction(ActionEvent event) {
        this.sendText.setText("");
        if(this.text1.getText().isBlank() || this.text2.getText().isBlank()) {
            this.sendText.setText("Einer der beiden Werte nicht gesetzt. Bitte machen!");
        } else if (this.case1.isSelected()) {
            this.sendText.setText(this.text1.getText() + " " + this.text2.getText());
        } else if (this.case2.isSelected()) {
            this.sendText.setText(this.text2.getText() + " " + this.text1.getText());
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // not TODO
    }
}

