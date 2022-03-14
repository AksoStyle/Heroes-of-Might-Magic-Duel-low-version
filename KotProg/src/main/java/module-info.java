module com.example.kotprog {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kotprog to javafx.fxml;
    exports com.example.kotprog;
}