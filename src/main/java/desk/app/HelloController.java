package desk.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloController {
@FXML
    ImageView moogleView;
@FXML
    Button switchMoogle;
    Image moogleImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("moogle11.png")));

    public Button login_button;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Integer counter;

@FXML
    private TextField username_text_field;

    public void displayMoogle(){
        moogleView.setImage(moogleImage);
    }

    public void  login(ActionEvent event)throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("scene2.fxml"));
        root = fxmlLoader.load();
        String userName = username_text_field.getText();
        Scene2Controller scene2Controller = fxmlLoader.getController();
        scene2Controller.displayName(userName);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}