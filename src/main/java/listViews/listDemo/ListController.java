package listViews.listDemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.ResourceBundle;

/**
 * Created: 25.05.2023 at 12:39
 *
 * @author Plasek Sebastian
 */
public class ListController implements Initializable {
    @FXML
    private ListView<String> listView;

    @FXML
    private TextField text;

    @FXML
    void handleAddAction(ActionEvent event) {
        add();
    }

    private void add() {
        if (!text.getText().isBlank()) {
            listView.getItems().add(text.getText());
            text.clear();
        }
    }

    @FXML
    void handleClearAction(ActionEvent event) {
        listView.getItems().clear();
    }

    @FXML
    void handleDeleteAction(ActionEvent event) {
        listView.getItems().remove(listView.getSelectionModel().getSelectedIndex());
    }

    @FXML
    void handleShuffleAction(ActionEvent event) {
        Collections.shuffle(listView.getItems());
    }

    @FXML
    void handleSortAction(ActionEvent event) {
        Collections.sort(listView.getItems());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        text.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                add();
            }
        });

        for (int i = 0; i < 10; i++) {
            listView.getItems().add("ListItem: " + i);
        }

    }
}
