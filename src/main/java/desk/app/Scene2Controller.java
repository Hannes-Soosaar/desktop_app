package desk.app;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Scene2Controller {
    @FXML
    private Label nameLabel;

     public void displayName(String userName){
       nameLabel.setText("Hey:"+ userName);
     }

}
