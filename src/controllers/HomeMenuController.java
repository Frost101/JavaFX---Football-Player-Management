package controllers;

import codes.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import network.ExitMessage;

import java.io.IOException;
import java.util.Locale;

import static java.lang.System.exit;

public class HomeMenuController {


    @FXML
    private ImageView searchPlayersImage;

    @FXML
    private ImageView searchClubImage;

    @FXML
    private ImageView marketPlaceImage;

    @FXML
    private ImageView sellPlayersImage;

    @FXML
    private ImageView logInImage;

    @FXML
    private ImageView exitImage;

    @FXML
    private ImageView imageHome;

    @FXML
    private Button homeButtonID;

    @FXML
    private Label clubNameLabelID;

    @FXML
    private ImageView clubImage;

    private Main main;


    @FXML
    void activeExitMenu(MouseEvent event) throws IOException {
        ExitMessage em = new ExitMessage();
        em.setClubname(main.getClientName());
        main.getClient().getNetworkUtil().write(em);
        exit(0);
    }

    @FXML
    void activeLogInMenu(MouseEvent event) throws IOException {
        ExitMessage em = new ExitMessage();
        em.setClubname(main.getClientName());
        main.getClient().getNetworkUtil().write(em);
        main.showLoginPage();
    }


    @FXML
    void activateMarketPlace(MouseEvent event) throws IOException {
        main.marketPlace();
    }

    @FXML
    void activateSellPlayers(MouseEvent event) throws IOException {
        main.sellPlayers();
    }

    @FXML
    void activeSearchClubMenu(MouseEvent event) throws IOException {
        main.clubSearchMenu();
    }

    @FXML
    void activeSearchPlayerMenu(MouseEvent event) throws IOException {
        main.searchPlayersMenu();
    }

    public void setMainAndInitialize(Main main) {
        this.main = main;
        Image image = new Image(getClass().getResourceAsStream("/images/others/home"+".png"));
        imageHome.setImage(image);
        imageHome.setPreserveRatio(false);

        image = new Image(getClass().getResourceAsStream("/images/others/search club"+".png"));
        searchClubImage.setImage(image);
        searchClubImage.setPreserveRatio(false);

        image = new Image(getClass().getResourceAsStream("/images/others/search players"+".png"));
        searchPlayersImage.setImage(image);
        searchPlayersImage.setPreserveRatio(false);

        image = new Image(getClass().getResourceAsStream("/images/others/market place"+".png"));
        marketPlaceImage.setImage(image);
        marketPlaceImage.setPreserveRatio(false);

        image = new Image(getClass().getResourceAsStream("/images/others/sell players"+".png"));
        sellPlayersImage.setImage(image);
        sellPlayersImage.setPreserveRatio(false);

        image = new Image(getClass().getResourceAsStream("/images/others/log out"+".png"));
        logInImage.setImage(image);
        logInImage.setPreserveRatio(false);

        image = new Image(getClass().getResourceAsStream("/images/others/exit"+".png"));
        exitImage.setImage(image);
        exitImage.setPreserveRatio(false);

        clubNameLabelID.setText(main.getClientName().toUpperCase(Locale.ROOT));

        image = new Image(getClass().getResourceAsStream("/images/logo/"+main.getClientName().toLowerCase(Locale.ROOT)+".png"));
        clubImage.setImage(image);
        clubImage.setPreserveRatio(false);
    }

}
