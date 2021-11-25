package ProyectoPOO.src;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class paginainicial { 

    @FXML
    private Button Actividades;

    @FXML
    private Button Lecturas;

    @FXML
    private Button Salir;

    @FXML
    private Button instituciones;

    @FXML
    void onPressActividades(ActionEvent event) {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("discusion.fxml"));
            Stage stage0 = (Stage) Actividades.getScene().getWindow();
            Stage stage1 = new Stage();
            stage0.close();
            stage1.setScene(new Scene(root));
            stage1.show();
        }catch(Exception e){
            System.out.println("Se ha producido el siguiente fallo "+e.getMessage());
        }
    }

    @FXML
    void onPressLecturas(ActionEvent event) throws  IOException {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("lecprincipal.fxml"));
            Stage stage0 = (Stage)  Lecturas.getScene().getWindow();
            Stage stage1 = new Stage();
            stage0.close();
            stage1.setScene(new Scene(root));
            stage1.show();
        }catch(Exception e){
                System.out.println("Se ha producido el siguiente fallo "+e.getCause());
            }
    }

    @FXML
    void onPressSalir(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Sesión cerrada exitosamente");
        alert.setContentText("¡Gracias por ser parte de esta comunidad!\n¡Te esperamos pronto!");
        alert.showAndWait();
        Platform.exit();
    }

    @FXML
    void oninstituciones(ActionEvent event) {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("instituciones.fxml"));
            Stage stage0 = (Stage) instituciones.getScene().getWindow();
            Stage stage1 = new Stage();
            stage0.close();
            stage1.setScene(new Scene(root));
            stage1.show();
        }catch(Exception e){
            System.out.println("Se ha producido el siguiente fallo "+e.getMessage());
        }
    }
}
