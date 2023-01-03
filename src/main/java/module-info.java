module com.example._14_cdio4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;
    requires org.testng;


    opens dtu._14_cdio4 to javafx.fxml;
    exports dtu._14_cdio4;
    exports dtu.dice;
}