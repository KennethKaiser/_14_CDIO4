package dtu._14_cdio4;

import dtu.board.Board;
import dtu.board.FerryField;
import dtu.board.FieldProperty;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        SceneSwitch sceneSwitch = new SceneSwitch(stage);
    }

    public static void main(String[] args) {

        Board board = new Board();

        FerryField ferryField = (FerryField)board.getCurrentBoard()[15];

        System.out.println(ferryField.getFerry().getName());

        launch();
    }

}