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
import java.util.*;

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
        if (single.isSelected()) {
            Integer item = from.getSelectionModel().getSelectedItem();
            if (item != null) {
                int newI = (Collections.binarySearch(to.getItems(), item) + 1) * -1;
                to.getItems().add(newI, item);
                from.getItems().remove(item);
            }
        } else {

            to.getItems().addAll(from.getSelectionModel().getSelectedItems());
            from.getItems().removeAll(from.getSelectionModel().getSelectedItems());
            Collections.sort(to.getItems());
        }
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
