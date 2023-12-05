package desk.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Scene2Controller {
    @FXML
    private Label nameLabel;
    @FXML
    private AnchorPane userPane;
    @FXML
    private Button logoutButton;

    Stage stage;

    public void logout(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("Your about to log out of the hello app");
        alert.setContentText("Do you want to save?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) userPane.getScene().getWindow();
            System.out.println("You logged out");
            stage.close();
        }
    }

    public void displayName(String userName) {
        nameLabel.setText("Hey:" + userName);
    }

}
