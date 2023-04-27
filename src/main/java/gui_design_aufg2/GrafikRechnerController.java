package gui_design_aufg2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created: 27.04.2023 at 11:36
 *
 * @author Plasek Sebastian
 */
public class GrafikRechnerController implements Initializable {

    @FXML
    private TextField num1;

    @FXML
    private TextField num2;

    @FXML
    private TextArea output;

    public void handleCalc() {
        try {
            if (num1.getText().isBlank() || num2.getText().isBlank()) {
                throw new IllegalArgumentException("Einer der beiden Texte ist leer!\n");
            } else {
                Double firstNum = Double.parseDouble(num1.getText());
                Double secondNum = Double.parseDouble(num2.getText());
                if (!output.getText().isBlank()) {
                    output.setText(output.getText() + "\n" + firstNum + " + " + secondNum + " = " + (firstNum + secondNum) + "\n");
                    output.setText(output.getText() + firstNum + " - " + secondNum + " = " + (firstNum - secondNum) + "\n");
                    output.setText(output.getText() + firstNum + " * " + secondNum + " = " + (firstNum * secondNum) + "\n");
                    if (secondNum.equals(0.0)) {
                        output.setText(output.getText() + firstNum + " / " + secondNum + " = Ist nicht möglich" + "\n");
                    } else {
                        output.setText(output.getText() + firstNum + " / " + secondNum + " = " + (firstNum / secondNum) + "\n");
                    }
                } else {
                    output.setText(firstNum + " + " + secondNum + " = " + (firstNum + secondNum) + "\n");
                    output.setText(output.getText() + firstNum + " - " + secondNum + " = " + (firstNum - secondNum) + "\n");
                    output.setText(output.getText() + firstNum + " * " + secondNum + " = " + (firstNum * secondNum) + "\n");
                    if (secondNum.equals(0.0)) {
                        output.setText(output.getText() + firstNum + " / " + secondNum + " = Ist nicht möglich" + "\n");
                    } else {
                        output.setText(output.getText() + firstNum + " / " + secondNum + " = " + (firstNum / secondNum) + "\n");
                    }
                }


            }
        } catch (NumberFormatException n) {
            output.setText("Eine der beiden Werte ist keine Zahl!\n");
        } catch (IllegalArgumentException i) {
            output.setText(i.getMessage());
        }
    }

    @FXML
    void handleBerechneAction(ActionEvent event) {
        handleCalc();
    }

    @FXML
    void handleLoescheAction(ActionEvent event) {
        output.clear();
        num1.clear();
        num2.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        num1.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                handleCalc();
            }
        });

        num2.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                handleCalc();
            }
        });

        output.setEditable(false);

    }
}
