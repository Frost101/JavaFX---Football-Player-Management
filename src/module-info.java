module myjfx {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    opens controllers to javafx.graphics, javafx.fxml, javafx.base;
    opens codes to javafx.graphics, javafx.fxml, javafx.base;
    opens fxml to javafx.graphics, javafx.fxml, javafx.base;
    opens network to javafx.graphics, javafx.fxml, javafx.base;

}