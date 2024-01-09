package desk.app;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BrowserController {

    @FXML
    private Button button; // change name to what is in the fxml file


    public void startBrowser() {
        Stage stage =new Stage();
        Parent root = null;

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("browser.fxml"));
            root = fxmlLoader.load();

            if (root != null){
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Little browser");
                stage.show();
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }






}
