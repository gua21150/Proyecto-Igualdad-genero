package ProyectoPOO.src;
import java.io.IOException;
import java.sql.SQLException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LogIn {

    @FXML
    private Label Recuperar;

    @FXML
    private Label Registrarse;

    @FXML
    private Button cancelar;

    @FXML
    private PasswordField contraseña;

    @FXML
    private Button ingresar;

    @FXML
    private TextField usuario;

    @FXML
    void onCancelarClick(ActionEvent event) {
        contraseña.clear();
        usuario.clear();
        Platform.exit();
    }

    @FXML
    void onIngresarClick(ActionEvent event) throws IOException, SQLException {
        if(Controlador.iniciarSesion(usuario.getText(), contraseña.getText())){
            contraseña.clear();
            usuario.clear();
            try
            {
                Parent root = FXMLLoader.load(getClass().getResource("paginainicial.fxml"));
                Stage stage0 = (Stage) ingresar.getScene().getWindow();
                Stage stage1 = new Stage();
                stage0.close();
                stage1.setScene(new Scene(root));
                stage1.show();
            }catch(Exception e){
                System.out.println("algo fallo: "+e.getMessage());
            }
        }else{
            contraseña.clear();
            usuario.clear();
        }
    }

    @FXML
    void onRecuperarClick(MouseEvent event) {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("recuperacion.fxml"));
            Stage stage0 = (Stage) Recuperar.getScene().getWindow();
            Stage stage1 = new Stage();
            stage0.close();
            stage1.setScene(new Scene(root));
            stage1.show();
        }catch(Exception e){
            System.out.println("algo fallo: "+e.getMessage());
        }
    }

    @FXML
    void onRegistroclick(MouseEvent event) {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("registro.fxml"));
            Stage stage0 = (Stage) Registrarse.getScene().getWindow();
            Stage stage1 = new Stage();
            stage0.close();
            stage1.setScene(new Scene(root));
            stage1.show();
        }catch(Exception e){
            System.out.println("algo fallo: "+e.getMessage());
        }
    }

}
