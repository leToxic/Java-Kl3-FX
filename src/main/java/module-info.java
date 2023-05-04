module com.example.javakl3fx {
    requires javafx.controls;
    requires javafx.fxml;

    opens gui_design_aufg1 to javafx.fxml;
    exports gui_design_aufg1;

    opens gui_design_aufg2 to javafx.fxml;
    exports gui_design_aufg2;

    opens mouseevents to javafx.fxml;
    exports mouseevents;
}