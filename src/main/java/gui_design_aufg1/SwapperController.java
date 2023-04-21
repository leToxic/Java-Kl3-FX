package gui_design_aufg1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created: 20.04.2023 at 12:33
 *
 * @author Plasek Sebastian
 */
public class SwapperController implements Initializable {

    @FXML
    private Text output;

    @FXML
    private TextField text1;

    @FXML
    private TextField text2;

    @FXML
    void handleClearAction(ActionEvent event) {
        output.setText("");
        text1.setText("");
        text2.setText("");
    }

    @FXML
    void handleSwapAction(ActionEvent event) {
        output.setText("");
        if(text1.getText().isBlank() || text2.getText().isBlank()) {
            this.output.setText("BOTH TEXTS MUST BE SET!");
        } else {
            String save = text1.getText();
            text1.setText(text2.getText());
            text2.setText(save);
            output.setText("Swapped");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // not TODO
    }
}
