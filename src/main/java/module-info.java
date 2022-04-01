module main.kotprog {
    requires javafx.controls;
    requires javafx.fxml;


    opens main.kotprog to javafx.fxml;
    exports main.kotprog;
}