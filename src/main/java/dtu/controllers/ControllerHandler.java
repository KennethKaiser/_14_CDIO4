package dtu.controllers;

public class ControllerHandler {

    public static ControllerHandler controllerHandler = null;

    public static ControllerHandler getInstance(){
        if(controllerHandler == null) controllerHandler = new ControllerHandler();
        return controllerHandler;
    }



}
