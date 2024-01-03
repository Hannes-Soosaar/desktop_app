package desk.app;

import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AnimationController {

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


    public void crazyMove(ImageView rocketImage) {
        TranslateTransition transitionRight = new TranslateTransition();
        System.out.println("running crazy move");
        this.rocketImage = rocketImage;
        transitionRight.setNode(this.rocketImage);
        transitionRight.setDuration(Duration.millis(1000));
        transitionRight.setByX(250);
        transitionRight.setByY(150);
        transitionRight.setCycleCount(2);
        transitionRight.setAutoReverse(true);
        transitionRight.play();

        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setNode(this.rocketImage);
        rotateTransition.setDuration(Duration.millis(2000));
        rotateTransition.setCycleCount(1);
        rotateTransition.setByAngle(360);
        rotateTransition.play();

        FadeTransition fade = new FadeTransition();
        fade.setNode(this.rocketImage);
        fade.setDuration(Duration.millis(1000));
        fade.setCycleCount(2);
        fade.setFromValue(1);
        fade.setToValue(0.1);
        fade.setAutoReverse(true);
        fade.play();

        ScaleTransition scale = new ScaleTransition();
        scale.setNode(this.rocketImage);
        scale.setDuration(Duration.millis(200));
        scale.setCycleCount(10);
        scale.setFromX(1);
        scale.setFromY(1);
        scale.setToX(0.1);
        scale.setToY(0.1);
        scale.setAutoReverse(true);
        scale.play();

    }

    public void startMiniGame() {
        KeyboardController keyboardController = new KeyboardController();
        Stage newStage = new Stage();
        Parent newRoot = null;

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("animation.fxml"));
            newRoot = fxmlLoader.load();
            AnimationController controller = fxmlLoader.getController();

            if (newRoot != null) {
                Scene newScene = new Scene(newRoot);
                newScene.setOnKeyPressed(keyEvent -> {

                    switch (keyEvent.getCode()) {

                        case W -> {
                            controller.rocketImage.setY(controller.rocketImage.getY() - 50);
                            System.out.println(controller.rocketImage.getY());
                        }

                        case A -> {
                            controller.rocketImage.setX(controller.rocketImage.getX() - 50);
                            System.out.println(controller.rocketImage.getX());
                        }

                        case S -> {
                            controller.rocketImage.setY(controller.rocketImage.getY() + 50);
                            System.out.println(controller.rocketImage.getX());
                        }
                        case D -> {
                            controller.rocketImage.setX(controller.rocketImage.getX() + 50);
                            System.out.println(controller.rocketImage.getX());
                        }
                        case E -> {
                            controller.rocketImage.setRotate(controller.rocketImage.getRotate() + 90);
                            System.out.println(controller.rocketImage.getX());
                        }
                        case Q -> {
                            controller.rocketImage.setRotate(controller.rocketImage.getRotate() - 90);
                            System.out.println(controller.rocketImage.getX());
                        }
                        case C -> {
                            crazyMove(controller.rocketImage);
                        }
                        default -> System.out.println("not a valid key");

                    }
                });
                newStage.setScene(newScene);
                newStage.setTitle("Rocket Game");
                newStage.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
