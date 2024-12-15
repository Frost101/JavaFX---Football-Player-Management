package controllers;

import codes.Main;
import codes.Option2MainMenu;
import codes.Players;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MaximumSalaryClubController{

    @FXML
    private ImageView goBackImage;

    @FXML
    private Label clubLabel;

    @FXML
    private ImageView clubImage;

    @FXML
    private GridPane gridPaneID;

    private Main main = new Main();
    private List<Players> list = new ArrayList();
    private Boolean active = true;


    public void setMainAndInitialize(Main main){
        this.main = main;
        active = true;

        clubLabel.setText(main.getClientName().toUpperCase(Locale.ROOT));

        Image image = new Image(getClass().getResourceAsStream("/images/logo/"+main.getClientName().toLowerCase(Locale.ROOT)+".png"));
        clubImage.setImage(image);
        clubImage.setPreserveRatio(false);

        image = new Image(getClass().getResourceAsStream("/images/others/go back"+".png"));
        goBackImage.setImage(image);
        goBackImage.setPreserveRatio(false);

        Thread th = new Thread(this::refresh);
        th.start();
    }


    @FXML
    void activateGoBack(MouseEvent event) throws IOException {
        active = false;
        main.clubSearchMenu();
    }


    public void refresh(){
        while(active) {

            Platform.runLater(() -> {
                initialize();

            });
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println(e);
            }
        }

        try {
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void initialize() {
        gridPaneID.getChildren().clear();
        list.clear();
        String clubName = main.getClientName();
        List<Players> tempList = Option2MainMenu.maximumSalaryClub((clubName));
        list.addAll(tempList);

        int column = 0;
        int row = 1;

        for (int i = 0; i < list.size(); i++) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/fxml/PlayerViewOne.fxml"));
            AnchorPane anchorPane = null;
            try {
                anchorPane = fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            PlayerViewOneController itemController = fxmlLoader.getController();
            itemController.setData(list.get(i));

            if (column == 1) {
                column = 0;
                row++;
            }
            gridPaneID.setAlignment(Pos.CENTER);
            gridPaneID.add(anchorPane, column++, row);
            GridPane.setMargin(anchorPane, new Insets(10));
        }
    }


}
