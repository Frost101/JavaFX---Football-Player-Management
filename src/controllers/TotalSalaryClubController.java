package controllers;

import codes.Main;
import codes.Option2MainMenu;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Ellipse;

import java.io.IOException;
import java.util.Locale;


public class TotalSalaryClubController {

    @FXML
    private TextField clubNameTextFieldID;

    @FXML
    private Button searchButtonID;

    @FXML
    private ImageView goBackImage;

    @FXML
    private ImageView clubImage;

    @FXML
    private Ellipse salaryOutputShapeID;

    @FXML
    private Label labelInsideShapeID;

    @FXML
    private Label clubNameLabelID;

    private Main main = new Main();
    private Double totalSalary;
    private String salary = "Total Yearly Salary";
    private String clubName = " ";
    private Boolean active = true;


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


    @FXML
    void initialize(){
        totalSalary = Option2MainMenu.totalYearlySalaryClub(main.getClientName());
        salary = String.format("%f",totalSalary);
        clubNameLabelID.setText(main.getClientName());
        labelInsideShapeID.setText(salary);
    }

    public void setMainAndInitialize(Main main) {
        this.main = main;
        active = true;

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
