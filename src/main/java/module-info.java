module desk.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens desk.app to javafx.fxml;
    exports desk.app;
}