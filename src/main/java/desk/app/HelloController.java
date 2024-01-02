package desk.app;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class HelloController {
    @FXML
    ImageView moogleView;
    @FXML
    Button switchMoogle;

    @FXML
    private CheckBox showImageCheckBox;
    Image moogleImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("moogle11.png")));
    Image moogleImage2 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("moogle22.png")));

    @FXML
    public Button login_button;
    @FXML
    private DatePicker dateSelect;
    @FXML
    private Label dateLabel;
    @FXML
    private ColorPicker backGroundColorPicker;
    @FXML
    private Pane helloPane;
    @FXML
    private Button button_option_list;
    @FXML
    private Button buttonTreeView;
    @FXML
    private MenuItem menuFileRocket;

    protected KeyboardController keyboardController = new KeyboardController();

    private Stage stage = new Stage();
    private Scene scene;
    private Parent root;

    @FXML
    private TextField username_text_field;

    public void displayMoogle() {
        moogleView.setImage(moogleImage);
    }

    public void toggleImage(ActionEvent event) {
        if (showImageCheckBox.isSelected()) {
            moogleView.setImage(moogleImage2);
        } else {
            moogleView.setImage(moogleImage);
        }
    }

    public void login(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("scene2.fxml"));
        root = fxmlLoader.load();
        String userName = username_text_field.getText();
        Scene2Controller scene2Controller = fxmlLoader.getController();
        scene2Controller.displayName(userName);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void openOptionList(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("option-list.fxml"));
        root = fxmlLoader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void startRocketGame(ActionEvent event) throws IOException {

            AnimationController animationController = new AnimationController();
            animationController.startMiniGame();

        }

    public void getDate(ActionEvent event) {
        LocalDate selectedDate = dateSelect.getValue();
        String dateDdMMYYYYFormat = dateSelect.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println(selectedDate);
        dateLabel.setText(dateDdMMYYYYFormat);
    }

    public void setBackgroundColor(ActionEvent event) {
        Color sellectedBackGroundColor = backGroundColorPicker.getValue();
        helloPane.setBackground(new Background(new BackgroundFill(sellectedBackGroundColor, null, null)));
    }

    public void openTreeView(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tree-view.fxml"));
        root = fxmlLoader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void creatNewFile() {
        System.out.println("New file created text printed to console!");
    }

    @FXML
    public void closeApplication(ActionEvent event) {
        System.out.println("You should closed the application");
    }
}