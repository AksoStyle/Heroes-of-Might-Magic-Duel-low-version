module main.kotprog {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens main.kotprog to javafx.fxml;
    exports main.kotprog;
}