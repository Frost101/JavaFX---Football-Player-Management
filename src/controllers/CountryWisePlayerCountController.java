package controllers;

import codes.Country;
import codes.Main;
import codes.Option1MainMenu;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CountryWisePlayerCountController {

    @FXML
    private TableView<Country> tableViewID;

    @FXML
    private TableColumn<Country,String> countryNameID;

    @FXML
    private TableColumn<Country, Integer> playerCountID;

    @FXML
    private ImageView goBackImage;

    @FXML
    private Label clubLabel;

    @FXML
    private ImageView clubImage;

    private Main main;
    private List<Country> list = new ArrayList();
    private ObservableList<Country> olist = FXCollections.observableList(list);
    private Boolean active = true;

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

    public void initializeColumns(){

        countryNameID.setCellValueFactory(new PropertyValueFactory<Country,String >("countryName"));
        playerCountID.setCellValueFactory(new PropertyValueFactory<Country, Integer>("playerCount"));

    }


    public void initialize(){
        initializeColumns();
        list = Option1MainMenu.countryWisePlayerCount();
        olist = FXCollections.observableList(list);
        tableViewID.setEditable(true);
        tableViewID.setItems(olist);
        tableViewID.refresh();
    }



    @FXML
    void activateGoBack(MouseEvent event) throws IOException {
        active = false;
        main.searchPlayersMenu();
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
