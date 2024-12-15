package controllers;

import codes.Players;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PlayerViewOneController {

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
    private ImageView imageViewID;

    private Players p;


    public void setData(Players p){
        nameLabelID.setText(p.getName());
        countryLabelID.setText(p.getCountry());
        clubLabelID.setText(p.getClub());
        ageLabelID.setText(Double.toString(p.getAge()));
        heightLabelID.setText(Double.toString(p.getHeight()));
        positionLabelID.setText(p.getPosition());
        numberLabelID.setText(Integer.toString(p.getNumber()));
        weeklySalaryLabelID.setText(Double.toString(p.getWeeklySalary()));
        Image image = new Image(getClass().getResourceAsStream("/images/players/"+p.getName()+".JPG"));
        imageViewID.setImage(image);
       imageViewID.setPreserveRatio(false);

        this.p = p;
    }

}
