module com.example._14_cdio4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens dtu._14_cdio4 to javafx.fxml;
    exports dtu._14_cdio4;
    exports dtu.dice;
    exports dtu.players;
    exports dtu.game;
    exports dtu.board;
    exports dtu.controllers;
    opens dtu.controllers to javafx.fxml;
}