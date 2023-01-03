module com.example._14_cdio4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;
    requires org.testng;


    opens com.example._14_cdio4 to javafx.fxml;
    exports com.example._14_cdio4;
}