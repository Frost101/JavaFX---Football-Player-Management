package controllers;

import codes.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.Locale;

public class SearchPlayersMenuController {

    @FXML
    private Button byPlayerNameButtonID;

    @FXML
    private Button byClubAndCountryButtonID;

    @FXML
    private Button byPositionButtonID;

    @FXML
    private Button bySalaryRangeButtonID;

    @FXML
    private Button countryWisePlayerCountButtonID;

    @FXML
    private Button backToMainMenuButtonID;

    @FXML
    private Button homeButtonID;

    @FXML
    private Label clubNameLabelID;

    @FXML
    private ImageView clubImage;

    private Main main;

    @FXML
    void activateBackToMainMenu(ActionEvent event) throws IOException {
        main.showHomeMenu();
    }

    @FXML
    void activateCountryWisePlayerCount(ActionEvent event) throws IOException {
        main.countryWisePlayerCount();
    }

    @FXML
    void activateSearchByClubAndCountry(ActionEvent event) throws IOException {
        main.searchByClubAndCountry();
    }

    @FXML
    void activateSearchByPlayerName(ActionEvent event) throws IOException {
        main.searchByPlayerName();
    }

    @FXML
    void activateSearchByPosition(ActionEvent event) throws IOException {
        main.searchByPosition();
    }

    @FXML
    void activateSearchBySalaryRange(ActionEvent event) throws IOException {
        main.searchBySalaryRange();
    }

    public void setMain(Main main) {
        this.main = main;
        clubNameLabelID.setText(main.getClientName().toUpperCase(Locale.ROOT));

        Image image = new Image(getClass().getResourceAsStream("/images/logo/"+main.getClientName().toLowerCase(Locale.ROOT)+".png"));
        clubImage.setImage(image);
        clubImage.setPreserveRatio(false);
    }
}
