package desk.app;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.input.KeyCode.W;

public class AnimationController implements Initializable {

    @FXML
    private ImageView rocketImage;

    Parent root;
    Stage stage;
    Scene scene;


    public void backToHello(ActionEvent event) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            root = fxmlLoader.load();
        } catch (Exception e) {
            System.out.println(e);
        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void moveRocket() {
        System.out.println("moveRocket()");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void startMiniGame(){
        KeyboardController keyboardController = new KeyboardController();
        Stage newStage = new Stage();
        Parent newRoot = null;

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("animation.fxml"));
            newRoot = fxmlLoader.load();
            AnimationController controller =fxmlLoader.getController();

        if (newRoot != null) {
            Scene newScene = new Scene(newRoot);
            newScene.setOnKeyPressed(keyEvent ->  {

                                             switch (keyEvent.getCode()) {

                                                 case W -> {
                                                     controller.rocketImage.setY(controller.rocketImage.getY()-50);
                                                     System.out.println(controller.rocketImage.getY());
                                                 }

                                                 case A -> {
                                                     controller.rocketImage.setX(controller.rocketImage.getX()-50);
                                                     System.out.println(controller.rocketImage.getX());
                                                 }

                                                 case S -> {
                                                     controller.rocketImage.setY(controller.rocketImage.getY()+50);
                                                     System.out.println(controller.rocketImage.getX());
                                                 }
                                                 case D -> {
                                                     controller.rocketImage.setX(controller.rocketImage.getX()+50);
                                                     System.out.println(controller.rocketImage.getX());
                                                 }
                                                 default -> System.out.println("not a valid key");

                                             }

                                     }
            );
            newStage.setScene(newScene);
            newStage.setTitle("Running In AnimationController");
            newStage.show();
        }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
