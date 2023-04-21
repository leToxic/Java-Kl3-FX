module com.example.javakl3fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javakl3fx to javafx.fxml;
    exports com.example.javakl3fx;
}