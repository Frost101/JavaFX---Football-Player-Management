package controllers;

import codes.Main;
import codes.Option1MainMenu;
import codes.Players;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import network.ListContainerClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SearchByPositionController{

    @FXML
    private TextField searchTextFieldID;

    @FXML
    private Button searchButtonID;

    @FXML
    private ImageView goBackImage;

    @FXML
    private Label clubLabel;

    @FXML
    private ImageView clubImage;


    @FXML
    private GridPane gridPaneID;

    private Main main;
    private List<Players> list = new ArrayList();
    private Boolean buttonClicked = false;
    private Boolean active = true;
    private Boolean result = true;


    @FXML
    void activateGoBack(MouseEvent event) throws IOException {
        active = false;
        buttonClicked = false;
        result = true;
        main.searchPlayersMenu();
    }

    public void refresh(){
        while(active && !buttonClicked) {

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

    @FXML
    void activateSearch(ActionEvent event) {
        buttonClicked = true;
        if(!list.isEmpty()) {
            list.clear();
        }
        String position = searchTextFieldID.getText();
        if(position.isEmpty()){
            main.showAlert("Invalid Input","Player's Position Text Field Is Empty","Please input data correctly");
            buttonClicked = false;
            result = true;
        }
        else {
            List<Players> tempList = Option1MainMenu.searchByPosition(position);
            if(tempList.isEmpty()){
                main.showAlert("Invalid Input","No Such Player With This Position. ","Please input player's position correctly");
                result = false;
            }
            else {
                list.clear();
                list.addAll(tempList);
            }
        }
        initialize();
    }



    public void initialize() {
        gridPaneID.getChildren().clear();
        if(!buttonClicked&&!list.isEmpty()){
            list.clear();
        }

        if(list.isEmpty()&&result) {
            list.addAll(ListContainerClient.playersList);
        }
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
            gridPaneID.setAlignment(Pos.TOP_CENTER);
            gridPaneID.add(anchorPane, column++, row);
            GridPane.setMargin(anchorPane, new Insets(10));
        }
    }

    public void setMainAndInitialize(Main main) {
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


}
