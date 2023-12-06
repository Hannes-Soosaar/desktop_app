package desk.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.ParallelCamera;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene2Controller {
    @FXML
    private Label nameLabel;
    @FXML
    private AnchorPane userPane;
    @FXML
    private Button logoutButton;
    @FXML
    private Button signupButton;
    @FXML
    private RadioButton professionalRadioButton;
    @FXML
    private RadioButton enterpriseRadioButton;
    @FXML
    private RadioButton publicRadioButton;
    @FXML
    private Label selectionDisplayText, vesrsionSellectText;
    private Parent root;
    private Stage stage;

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

    public void sellectVersion(ActionEvent event) {

        if (professionalRadioButton.isSelected()) {
            selectionDisplayText.setText("You have chosen the: professional version");
        } else if (enterpriseRadioButton.isSelected()) {
            selectionDisplayText.setText("You have chosen the: enterpirse version");
        } else if (publicRadioButton.isSelected()) {
            selectionDisplayText.setText("You have chosen the: public version");
        } else {
            selectionDisplayText.setText("You have chosen the: professional version");
        }

    }

    @FXML
    public void sigIn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("signup.fxml"));
        root = fxmlLoader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
