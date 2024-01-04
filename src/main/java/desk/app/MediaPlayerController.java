package desk.app;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.File;
import java.io.IOException;
import java.net.FileNameMap;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MediaPlayerController implements Initializable {

    @FXML
    private MediaView mediaView;
    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;


    public void playMedia() {
mediaPlayer.play();

    }

    public void pauseMedia() {
        mediaPlayer.pause();

    }

    public void closeMedia() {
    mediaPlayer.seek(Duration.seconds(0.0));
    mediaPlayer.pause();
    }

    public void startMediaPlayer() {
        Stage stage = new Stage();
        Parent root = null;

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("media-player.fxml"));
            root = fxmlLoader.load();

            if (root != null) {
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
        try {
            file = new File("src/main/resources/desk/app/clip.mp4");
            media = new Media(file.toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            mediaView.setMediaPlayer(mediaPlayer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
