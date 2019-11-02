package br.imd.Controller;

import br.imd.View.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class FXMLMainController{

    @FXML
    private TextField imagePath;

    @FXML
    private Button browseButton;

    @FXML
    private ImageView imgViewer;

    @FXML
    private ToggleGroup distances;

    @FXML
    private Button aboutButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button runButton;

    @FXML
    void aboutAction(ActionEvent event) {

    }

    @FXML
    void browseAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image File");

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image files extension","*.png");

        fileChooser.getExtensionFilters().add(extFilter);

        File selectedFile = fileChooser.showOpenDialog(Main.getStage());
        try {
            imagePath.setText(selectedFile.getAbsolutePath());

            //Showing the image
            File file = new File(selectedFile.getAbsolutePath());
            Image image = new Image(file.toURI().toString());
            imgViewer.setImage(image);

        } catch (NullPointerException ex){
            imagePath.setText("Invalid Path");
        }
    }

    @FXML
    void exitAction(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void runAction(ActionEvent event) {

    }

}
