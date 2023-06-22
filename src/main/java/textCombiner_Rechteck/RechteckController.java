package textCombiner_Rechteck;

import javafx.beans.binding.StringBinding;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class RechteckController implements Initializable {

    @FXML
    private Slider breite;

    @FXML
    private Slider hoehe;

    @FXML
    private ChoiceBox<Color> color;

    @FXML
    private Text flaeche;

    @FXML
    private Rectangle rechteck;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.rechteck.widthProperty().bind(breite.valueProperty());
        this.rechteck.heightProperty().bind(hoehe.valueProperty());

        hoehe.setValue(25);
        breite.setValue(25);

        flaeche.textProperty().bind(new StringBinding() {

            {
                super.bind(rechteck.widthProperty(), rechteck.heightProperty());
            }

            @Override
            protected String computeValue() {
                return String.format("%d E²", Math.round(rechteck.getWidth() * rechteck.getHeight()));
            }
        });

        color.getItems().addAll(Color.RED, Color.BLACK, Color.BLUE, Color.OLIVE, Color.web("#9cce2b"));
        color.getSelectionModel().select(0);
        this.rechteck.fillProperty().bind(color.valueProperty());
    }
}
