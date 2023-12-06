package desk.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML
    private Label signUpLabel;
    @FXML
    private Button addAgeButton;
    @FXML
    private TextField ageField;
    Integer age;
    public void registerAge(ActionEvent event) {

        try {
            age = Integer.parseInt(ageField.getText());

            if (age >= 18) {
                signUpLabel.setText("You are signed up");
            } else {
                signUpLabel.setText("You must be 18 or older");
            }

        } catch (NumberFormatException e) {
            signUpLabel.setText("Enter only Numbers");
        } catch (Exception e) {
            signUpLabel.setText(String.valueOf(e));
        }

    }

}
