module main.kotprog {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.security.jgss;


    opens main.kotprog to javafx.fxml;
    exports main.kotprog;
    exports view;
    opens view to javafx.fxml;
}