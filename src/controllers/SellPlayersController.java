package controllers;

import codes.Client;
import codes.Main;
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
import network.ListContainerClient;
import network.TransferPlayer;
import util.NetworkUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SellPlayersController{

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


    @FXML
    void activateGoBack(MouseEvent event) throws IOException {
        active = false;
        main.showHomeMenu();
    }


    public void initialize() {
        gridPaneID.getChildren().clear();
        if(!list.isEmpty()) {
            list.clear();
        }
        String clubName = main.getClientName();
        List<Players> tempList = new ArrayList<>();
        tempList.addAll(ListContainerClient.playersList);
        for(Players p: tempList){
            Boolean flag = true;
            for(Players p1: ListContainerClient.marketList){
                if(p.getName().equalsIgnoreCase(p1.getName())){
                    flag = false;
                    break;
                }
            }
            if(flag){
                list.add(p);
            }
        }

        int column = 0;
        int row = 1;

        for (int i = 0; i < list.size(); i++) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/fxml/PlayerViewTwo.fxml"));
            AnchorPane anchorPane = null;
            try {
                anchorPane = fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            PlayerViewTwoController itemController = fxmlLoader.getController();
            itemController.setSellPlayersController(this);
            itemController.setMain(main);
            itemController.setData(list.get(i),"Sell");

            if (column == 1) {
                column = 0;
                row++;
            }
            gridPaneID.setAlignment(Pos.CENTER);
            gridPaneID.add(anchorPane, column++, row);
            GridPane.setMargin(anchorPane, new Insets(5));

            if(i==4) System.out.println(i);
        }
    }




    public void activateTransfer(String name) throws IOException {

        for(Players p : ListContainerClient.playersList){
            if(p.getName().equalsIgnoreCase(name)){
                TransferPlayer tp = new TransferPlayer(p);
                tp.setTransferStatus("Sell");
                tp.setClubName(main.getClientName());
                Client client = main.getClient();
                NetworkUtil networkUtil = client.getNetworkUtil();
                networkUtil.write(tp);
                break;
            }
        }

    }


}
