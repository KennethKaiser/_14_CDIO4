package dtu._14_cdio4;

import dtu.board.Board;
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

        FieldProperty fieldProperty = (FieldProperty)board.getCurrentBoard()[1];



        launch();
    }

}