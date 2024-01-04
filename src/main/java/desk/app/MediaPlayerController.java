package desk.app;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.File;
import java.net.FileNameMap;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.*;
import javafx.stage.Stage;

public class MediaPlayerController implements Initializable {

    @FXML
    private MediaView mediaView;
    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;


    public void playMedia() {

    }

    public void pauseMedia() {

    }

    public void closeMedia() {

    }

    public void startMediaPlayer() {
        Stage stage = new Stage();
        Parent root = null;

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("media-player.fxml"));
            root= fxmlLoader.load();

            if (root != null){
                System.out.println("running media player");
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Media player");
                stage.show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
