package desk.app;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Callable;

public class SignUpController implements Initializable {

    @FXML
    private Label signUpLabel;
    @FXML
    private TextField ageField;
    @FXML
    private Label statusLabel;
    @FXML
    private ChoiceBox<String> selectStatus;
    @FXML
    private Slider tempVerticalSlider;
    @FXML
    private Label tempLabel;
    @FXML
    private ProgressBar tempStatusBar;
    @FXML
    private Label tempStatus;
    private BigDecimal boilingProgress;
    private int temperature;
    private final String[] selectionOptions = {"option1", "option2", "option3"};
    Integer age;

    public void registerAge(ActionEvent event) {

        try {
            age = Integer.parseInt(ageField.getText());

            if (age >= 18) {
                signUpLabel.setText("You are signed up");
            } else {
                signUpLabel.setText("You must be 18 or older");
            }

        } catch (NumberFormatException e) {
            signUpLabel.setText("Enter only Numbers");
        } catch (Exception e) {
            signUpLabel.setText(String.valueOf(e));
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tempStatusBar.setStyle("-fx-accent: #00FF00;");


                selectStatus.getItems().addAll(selectionOptions);
        selectStatus.setOnAction(this::getOption);

        temperature = (int) tempVerticalSlider.getValue();
        tempLabel.setText(temperature + "C");
        tempVerticalSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                temperature = (int) tempVerticalSlider.getValue();
                boilingProgress = new BigDecimal(String.format("%.2f",(double)temperature));
                tempStatus.setText(boilingProgress.toString());
                tempStatusBar.setProgress((boilingProgress.doubleValue())/100);
                tempLabel.setText(temperature + "C");
            }
        });
    }

    public void getOption(ActionEvent event) {
        String selectedOption = selectStatus.getValue();
        statusLabel.setText(selectedOption);

    }

}
