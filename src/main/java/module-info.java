module com.example.javakl3fx {
    requires javafx.controls;
    requires javafx.fxml;

    opens gui_design_aufg1 to javafx.fxml;
    exports gui_design_aufg1;

    opens gui_design_aufg2 to javafx.fxml;
    exports gui_design_aufg2;

    opens mouseevents to javafx.fxml;
    exports mouseevents;

    opens listViews.listDemo to javafx.fxml;
    exports listViews.listDemo;

    opens listViews.numberList to javafx.fxml;
    exports listViews.numberList;

    opens listViews.logger to javafx.fxml;
    exports listViews.logger;

    opens textCombiner_Rechteck to javafx.fxml;
    exports textCombiner_Rechteck;
}