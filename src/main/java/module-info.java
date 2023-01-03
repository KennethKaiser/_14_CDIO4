module dtu._14_CDIO4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens dtu._14_cdio4 to javafx.fxml;
    exports dtu._14_cdio4;
    exports dtu.dice;
}