package controllers;


import codes.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class LoginPageController {

    @FXML
    private Button buttonID;

    @FXML
    private TextField textFieldID;

    @FXML
    private Label labelID;

    @FXML
    private ImageView imageViewID;

    private Main main;
    private String clubName;

    @FXML
    void activateLogin(ActionEvent event) throws IOException {
        clubName = textFieldID.getText();
            main.initializeClient(clubName);
            if(main.getClient().getConnected()) {
                main.setClientName(clubName);
                main.showHomeMenu();
            }


    }

    public void setMain(Main main) {
        this.main = main;
        Image image = new Image(getClass().getResourceAsStream("/images/others/login"+".JPG"));
        imageViewID.setImage(image);
        imageViewID.setPreserveRatio(false);
    }
}
