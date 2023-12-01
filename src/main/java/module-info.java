module desk.app {
    requires javafx.controls;
    requires javafx.fxml;


    opens desk.app to javafx.fxml;
    exports desk.app;
}