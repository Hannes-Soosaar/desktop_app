package desk.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TreeViewController implements Initializable {

    @FXML
    private Button returnToHello;
    @FXML
    private TreeView<String> treeView;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void backToHello(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        root = fxmlLoader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        TreeItem<String> root = new TreeItem<String>("Main");
        TreeItem<String> level1 = new TreeItem<String>("level1");
        TreeItem<String> level2 = new TreeItem<String>("level2");
        TreeItem<String> level3 = new TreeItem<String>("level3");
        TreeItem<String> level4 = new TreeItem<String>("level4");
        TreeItem<String> level1room1 = new TreeItem<String>("level1room1");
        TreeItem<String> level1room2 = new TreeItem<String>("level1room2");
        TreeItem<String> level1room3 = new TreeItem<String>("level1room3");
        TreeItem<String> level2room1 = new TreeItem<String>("level2room1");
        TreeItem<String> level2room2 = new TreeItem<String>("level2room2");
        TreeItem<String> level2room3 = new TreeItem<String>("level2room3");
        TreeItem<String> level3room1 = new TreeItem<String>("level3room1");
        TreeItem<String> level3room2 = new TreeItem<String>("level3room2");
        TreeItem<String> level3room3 = new TreeItem<String>("level3room3");

        root.getChildren().addAll(level1, level2, level3);
        level1.getChildren().addAll(level1room1, level1room2, level1room3);
        level2.getChildren().addAll(level2room1, level2room2, level2room3);
        level3.getChildren().addAll(level3room1, level3room2, level3room3);

        treeView.setRoot(root);
    }

    @FXML
    public void selectedItem() {
        TreeItem<String> selectedItem = treeView.getSelectionModel().getSelectedItem();
        if(selectedItem != null){
            System.out.println(selectedItem.getValue());
        }
    }
}
