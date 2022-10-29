module connectx {
    requires javafx.controls;
    requires javafx.fxml;

    opens connectx to javafx.fxml;
    exports connectx;
}
