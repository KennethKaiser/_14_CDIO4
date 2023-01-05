package dtu._14_cdio4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Current.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 1500, 700);
        stage.setTitle("Matador");
        stage.setScene(scene);
        stage.show();

        BoardController1 controller = fxmlLoader.getController();
        controller.instantiateBoard();

    }

    public static void main(String[] args) {
        launch();
    }
}