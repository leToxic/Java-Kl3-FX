package gui_design_aufg2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created: 20.04.2023 at 12:58
 *
 * @author Plasek Sebastian
 */
public class AktionHandler implements Initializable {

    @FXML
    private RadioButton deleteIt;

    @FXML
    private RadioButton doubleIt;

    @FXML
    private ToggleGroup rGroup;

    @FXML
    private TextField text;

    @FXML
    private RadioButton uppercase;

    @FXML
    void handleAktionAction(ActionEvent event) {
        if (!text.getText().isBlank()) {
            if (deleteIt.isSelected()) {
                text.setText("");
            } else if (doubleIt.isSelected()) {
                text.setText(text.getText() + text.getText());
            } else if (uppercase.isSelected()) {
                text.setText(text.getText().toUpperCase());
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // not TODO
    }
}
