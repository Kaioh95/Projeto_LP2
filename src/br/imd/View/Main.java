package br.imd.View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class Main extends Application {
    private static Stage stage;
    private static Scene main;
    private static Scene run;

    @Override
    public void start(Stage primaryStage) throws Exception{
        /*
        Parent root = FXMLLoader.load(getClass().getResource("br.imd.View.FXMLMain.fxml"));
        primaryStage.setTitle("Person Detector");
        primaryStage.setScene(new Scene(root, 600, 480));
        primaryStage.show();
        */
        stage = primaryStage;
        stage.setTitle("Person Detector");
        URL url = new File("src/br/imd/View/FXMLMain.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        main = new Scene(root, 600, 480);
        stage.setScene(main);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getStage(){
        return stage;
    }
}
/*
public class Main {
    static{
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        CSVDataReader data = new CSVDataReader();
        data.readAllData(data.getCsv_path());

        FeatureExtraction fext = new FeatureExtraction();
        List<Float> imgFeatures = fext.extract("data/sampleimage.png");

        KNNAlgorithm k_nn = new KNNAlgorithm();
        k_nn.k_nn(data.getDataset(), imgFeatures, 3, 1);
    }
*/

