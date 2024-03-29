package PickYourSpot;

import PickYourSpot.exceptions.UsernameAlreadyExistsException;
import PickYourSpot.services.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class Main extends Application {

    private static Scene scene;
    private static Stage window;

    public static Stage getWindow() {
        return window;
    }
    public static Scene getScene() {
        return scene;
    }

    public static void setScene(Scene scene) {
        Main.scene = scene;
    }

    public static void setWindow(Stage window) {
        Main.window = window;
    }

    public static void main(String[] args) {
        launch(args);
    }




    @Override
    public void start(Stage primaryStage) throws Exception {
        UserService.initDatabase();
        ReservationService.initDatabase();
        MovieService.initDatabase();
        LocuriService.initDatabase();
        try {
            UserService.addUser("admin", "admin", "Admin");

        } catch (UsernameAlreadyExistsException e) { }


        window = primaryStage;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("firstpage.fxml")));
        primaryStage.setTitle("Pick Your Spot");
        scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }






}
