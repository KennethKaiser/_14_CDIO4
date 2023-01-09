package dtu._14_cdio4;

import dtu.board.Board;
import dtu.board.DummyField;
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

        /*FerryField ferryField = (FerryField)board.getCurrentBoard()[15];
        FerryField ferryField2 = (FerryField)board.getCurrentBoard()[5];
        FerryField ferryField3 = (FerryField)board.getCurrentBoard()[25];
        FerryField ferryField4 = (FerryField)board.getCurrentBoard()[35];

        System.out.println(ferryField.getFerry().getName());
        System.out.println(ferryField2.getFerry().getName());
        System.out.println(ferryField3.getFerry().getName());
        System.out.println(ferryField4.getFerry().getName());*/

        DummyField dummyField = (DummyField)board.getCurrentBoard()[0];
        DummyField dummyField2 = (DummyField)board.getCurrentBoard()[10];
        DummyField dummyField3 = (DummyField)board.getCurrentBoard()[20];

        System.out.println(dummyField.getDummy().getName());
        System.out.println(dummyField2.getDummy().getName());
        System.out.println(dummyField3.getDummy().getName());


        launch();
    }

}