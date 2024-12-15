package codes;

import controllers.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;



public class Main extends Application {

    private Stage stage;
    String serverAddress = "127.0.0.1";
    int serverPort = 33339;
    private String clientName;
    Client client = new Client();
    private String currentStatus = " ";

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        showLoginPage();
    }

    public FXMLLoader showStage(String fxmlFile) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Parent root = loader.load();

        stage.setTitle("Football Manager 2021");
        stage.setScene(new Scene(root, 950, 700));
        stage.show();
        return loader;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientName() {
        return clientName;
    }

    public void initializeClient(String clientName){
        Client clnt = new Client(serverAddress, serverPort, clientName, this);
        this.client = clnt;
    }

    public void showAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public void showLoginPage() throws IOException {
        LoginPageController controller = showStage("/fxml/LoginPage.fxml").getController();
        controller.setMain(this);
    }

    public void showHomeMenu() throws IOException {
        HomeMenuController controller = showStage("/fxml/HomeMenu.fxml").getController();
        controller.setMainAndInitialize(this);
    }


    public void searchPlayersMenu() throws IOException {
        SearchPlayersMenuController controller = showStage("/fxml/SearchPlayersMenu.fxml").getController();
        controller.setMain(this);
    }

    public void clubSearchMenu() throws IOException {
        ClubSearchMenuController controller = showStage("/fxml/ClubSearchMenu.fxml").getController();
        controller.setMain(this);
    }

    public void searchByPlayerName() throws IOException {
        SearchByPlayerNameController controller = showStage("/fxml/SearchByPlayerName.fxml").getController();
        controller.setMainAndInitialize(this);
    }

    public void searchByClubAndCountry() throws IOException {
        SearchByClubAndCountryController controller = showStage("/fxml/SearchByClubAndCountry.fxml").getController();
        controller.setMainAndInitialize(this);
    }

    public void searchByPosition() throws IOException {
        SearchByPositionController controller = showStage("/fxml/SearchByPosition.fxml").getController();
        controller.setMainAndInitialize(this);
    }

    public void searchBySalaryRange() throws IOException {
        SearchBySalaryRangeController controller = showStage("/fxml/SearchBySalaryRange.fxml").getController();
        controller.setMainAndInitialize(this);
    }

    public void countryWisePlayerCount() throws IOException {
        CountryWisePlayerCountController controller = showStage("/fxml/CountryWisePlayerCount.fxml").getController();
        controller.setMainAndInitialize(this);
    }

    public void maximumSalaryClub() throws IOException {
        MaximumSalaryClubController controller = showStage("/fxml/MaximumSalaryClub.fxml").getController();
        controller.setMainAndInitialize(this);
    }

    public void maximumAgeClub() throws IOException {
        MaximumAgeClubController controller = showStage("/fxml/MaximumAgeClub.fxml").getController();
        controller.setMainAndInitialize(this);
    }

    public void maximumHeightClub() throws IOException {
        MaximumHeightClubController controller = showStage("/fxml/MaximumHeightClub.fxml").getController();
        controller.setMainAndInitialize(this);
    }

    public void totalSalaryClub() throws IOException {
       TotalSalaryClubController controller = showStage("/fxml/TotalSalaryClub.fxml").getController();
        controller.setMainAndInitialize(this);
    }

    public void marketPlace() throws IOException {
        MarketPlaceController controller = showStage("/fxml/MarketPlace.fxml").getController();
        controller.setMainAndInitialize(this);
    }

    public void sellPlayers() throws IOException {
        SellPlayersController controller = showStage("/fxml/SellPlayers.fxml").getController();
        controller.setMainAndInitialize(this);
    }


    public static void main(String[] args) {
        launch(args);
    }

}
