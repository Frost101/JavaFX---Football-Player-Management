package controllers;

import codes.Main;
import codes.Players;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import network.ListContainerClient;

import java.io.IOException;

public class PlayerViewTwoController {

    @FXML
    private Label nameLabelID;

    @FXML
    private Label countryLabelID;

    @FXML
    private Label clubLabelID;

    @FXML
    private Label ageLabelID;

    @FXML
    private Label heightLabelID;

    @FXML
    private Label positionLabelID;

    @FXML
    private Label numberLabelID;

    @FXML
    private Label weeklySalaryLabelID;


    @FXML
    private Label actionLabel;


    private Players p;
    private String status = " ";
    private MarketPlaceController marketPlaceController;
    private SellPlayersController sellPlayersController;
    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

   @FXML
    void activateButton(MouseEvent event) throws IOException {
        if(status.equalsIgnoreCase("buy")){
           marketPlaceController.activateTransfer(p);
        }
        else{
            Boolean found = false;
            for(Players p1 : ListContainerClient.marketList){
                if(p1.getName().equalsIgnoreCase(p.getName())){
                    found = true;
                }
            }

            if(found){
              main.showAlert("Invalid Command","This Player is already added to the market list. ","You can sell other players");
            }
            else {
                sellPlayersController.activateTransfer(p.getName());
            }
        }
    }


    public void setData(Players p,String s){
        actionLabel.setText(s);
        setStatus(s);
        nameLabelID.setText(p.getName());
        countryLabelID.setText(p.getCountry());
        clubLabelID.setText(p.getClub());
        ageLabelID.setText(Double.toString(p.getAge()));
        heightLabelID.setText(Double.toString(p.getHeight()));
        positionLabelID.setText(p.getPosition());
        numberLabelID.setText(Integer.toString(p.getNumber()));
        weeklySalaryLabelID.setText(Double.toString(p.getWeeklySalary()));
        this.p = p;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMarketPlaceController(MarketPlaceController marketPlaceController) {
        this.marketPlaceController = marketPlaceController;
    }

    public void setSellPlayersController(SellPlayersController sellPlayersController) {
        this.sellPlayersController = sellPlayersController;
    }


}
