package desk.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;


    @FXML
    private Circle circle;
    @FXML
    private double x;
    @FXML
    private double y;

    @FXML
    private Label welcomeText;
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected void up() {
    System.out.println("Up");
    circle.setCenterY(y-=10);
    }
    @FXML
    protected void down() {
    System.out.println("Down");
        circle.setCenterY(y+=10);
    }
    @FXML
    protected void right() {
    System.out.println("Right");
        circle.setCenterX(x+=10);
    }
    @FXML
    protected void left() {
    System.out.println("Left");
        circle.setCenterX(x-=10);
    }
    @FXML
    public void switchToHelloView(ActionEvent event)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
    public void switchToScene2(ActionEvent event)throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("scene2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

}