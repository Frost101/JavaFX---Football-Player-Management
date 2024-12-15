package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.Locale;

public class ClubSearchMenuController<Main> {

    @FXML
    private Button playersWithTheMaximumSalaryButtonID;

    @FXML
    private Button playersWithTheMaximumAgeButtonID;

    @FXML
    private Button playersWithTheMaximumHeightButtonID;

    @FXML
    private Button totalSalaryButtonID;

    @FXML
    private Button backToMainMenuButtonID;

    @FXML
    private Button homeButtonID;

    @FXML
    private Label clubNameLabelID;

    @FXML
    private ImageView clubImage;


    private codes.Main main;

    @FXML
    void activateBackToMainMenu(ActionEvent event) throws IOException {
        main.showHomeMenu();
    }

    @FXML
    void activatePlayersWithTheMaximumAgeMenu(ActionEvent event) throws IOException {
        main.maximumAgeClub();
    }

    @FXML
    void activatePlayersWithTheMaximumHeightMenu(ActionEvent event) throws IOException {
        main.maximumHeightClub();
    }

    @FXML
    void activatePlayersWithTheMaximumSalaryMenu(ActionEvent event) throws IOException {
        main.maximumSalaryClub();
    }

    @FXML
    void activateTotalSalaryButtonIDMenu(ActionEvent event) throws IOException {
        main.totalSalaryClub();
    }

    public void setMain(codes.Main main) {
        this.main = main;

        clubNameLabelID.setText(main.getClientName().toUpperCase(Locale.ROOT));

        Image image = new Image(getClass().getResourceAsStream("/images/logo/"+main.getClientName().toLowerCase(Locale.ROOT)+".png"));
        clubImage.setImage(image);
        clubImage.setPreserveRatio(false);
    }
}
