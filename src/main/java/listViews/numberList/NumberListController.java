package listViews.numberList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;

/**
 * Created: 25.05.2023 at 13:02
 *
 * @author Plasek Sebastian
 */
public class NumberListController implements Initializable {
    @FXML
    private ListView<Integer> left;

    @FXML
    private RadioButton multiple;

    @FXML
    private ListView<Integer> right;

    @FXML
    private RadioButton single;

    @FXML
    private ToggleGroup tg;

    @FXML
    void handleToLeftAction(ActionEvent event) {
        makeDirection(right, left);
    }

    private void makeDirection(ListView<Integer> from, ListView<Integer> to) {
        ArrayList<Integer> pass = new ArrayList<>();
        if (single.isSelected()) {
            pass.add(from.getSelectionModel().getSelectedItem());
        } else {
            pass.addAll(from.getSelectionModel().getSelectedItems());
        }
        from.getItems().removeAll(pass);
        to.getItems().addAll(pass);
        Collections.sort(from.getItems());
        Collections.sort(to.getItems());
    }

    @FXML
    void handleToRightAction(ActionEvent event) {
        makeDirection(left, right);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (int i = 0; i <= 100; i++) {
            left.getItems().add(i);
        }

        single.pressedProperty().addListener((observableValue, aBoolean, t1) -> {
            this.left.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            this.right.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        });

        multiple.pressedProperty().addListener((observableValue, aBoolean, t1) -> {
            this.left.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            this.right.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        });
    }
}
