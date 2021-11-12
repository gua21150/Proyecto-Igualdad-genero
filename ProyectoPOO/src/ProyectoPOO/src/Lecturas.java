package ProyectoPOO.src;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Lecturas {

    @FXML
    private Button Foro;

    @FXML
    private Button Inicio;

    @FXML
    private Button Lectura1;

    @FXML
    private Button Lectura2;

    @FXML
    private Button Lectura3;

    @FXML
    private Button Lectura4;

    @FXML
    private Button Lectura5;

    @FXML
    void Foro(ActionEvent event) throws IOException {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("discusion.fxml"));
            Stage stage0 = (Stage)  Foro.getScene().getWindow();
            Stage stage1 = new Stage();
            stage0.close();
            stage1.setScene(new Scene(root));
            stage1.show();
            }catch(Exception e){
            System.out.println("algo fallo: "+e.getCause());
        }
    }

    @FXML
    void OnInicio(ActionEvent event) throws IOException{
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("paginainicial.fxml"));
            Stage stage0 = (Stage)  Inicio.getScene().getWindow();
            Stage stage1 = new Stage();
            stage0.close();
            stage1.setScene(new Scene(root));
            stage1.show();
            }catch(Exception e){
            System.out.println("algo fallo: "+e.getCause());
        }
    }

    @FXML
    void OnLectura1(ActionEvent event) throws IOException{
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("lectura1.fxml"));
            Stage stage0 = (Stage)  Lectura1.getScene().getWindow();
            Stage stage1 = new Stage();
            stage0.close();
            stage1.setScene(new Scene(root));
            stage1.show();
            }catch(Exception e){
            System.out.println("algo fallo: "+e.getCause());
        }
    }

    @FXML
    void OnLectura2(ActionEvent event) {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("lectura2.fxml"));
            Stage stage0 = (Stage)  Lectura2.getScene().getWindow();
            Stage stage1 = new Stage();
            stage0.close();
            stage1.setScene(new Scene(root));
            stage1.show();
            }catch(Exception e){
            System.out.println("algo fallo: "+e.getCause());
        }
    }

    @FXML
    void OnLectura5(ActionEvent event) {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("lectura5.fxml"));
            Stage stage0 = (Stage)  Lectura5.getScene().getWindow();
            Stage stage1 = new Stage();
            stage0.close();
            stage1.setScene(new Scene(root));
            stage1.show();
            }catch(Exception e){
            System.out.println("algo fallo: "+e.getCause());
        }
    }

    @FXML
    void Onlectura3(ActionEvent event) {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("lectura3.fxml"));
            Stage stage0 = (Stage)  Lectura3.getScene().getWindow();
            Stage stage1 = new Stage();
            stage0.close();
            stage1.setScene(new Scene(root));
            stage1.show();
            }catch(Exception e){
            System.out.println("algo fallo: "+e.getCause());
        }
    }

    @FXML
    void Onlectura4(ActionEvent event) {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("lectura4.fxml"));
            Stage stage0 = (Stage)  Lectura4.getScene().getWindow();
            Stage stage1 = new Stage();
            stage0.close();
            stage1.setScene(new Scene(root));
            stage1.show();
            }catch(Exception e){
            System.out.println("algo fallo: "+e.getCause());
        }
    }

}


