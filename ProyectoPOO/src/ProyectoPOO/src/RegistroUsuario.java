package ProyectoPOO.src;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistroUsuario {

    @FXML
    private TextField answer;

    @FXML
    private Button cancelar;

    @FXML
    private TextField correo;

    @FXML
    private TextField nombre;

    @FXML
    private PasswordField password;

    @FXML
    private TextField question;

    @FXML
    private Button register;

    @FXML
    private TextField telefono;

    @FXML
    private TextField username;

    @FXML
    void OnCancelarPress(ActionEvent event) {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Stage stage0 = (Stage) cancelar.getScene().getWindow();
            Stage stage1 = new Stage();
            stage0.close();
            stage1.setScene(new Scene(root));
            stage1.show();
        }catch(Exception e){
            System.out.println("Se ha producido el siguiente fallo "+e.getMessage());
        }
    }

    @FXML
    void OnRegisterClick(ActionEvent event) throws SQLException, IOException {
        if(Controlador.registrarUsuarios(correo.getText(), nombre.getText(), telefono.getText(), username.getText(), password.getText(), question.getText(), answer.getText()))
        {
            try
            {
                Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
                Stage stage0 = (Stage) cancelar.getScene().getWindow();
                Stage stage1 = new Stage();
                stage0.close();
                stage1.setScene(new Scene(root));
                stage1.show();
            }catch(Exception e){
                System.out.println("Se ha producido el siguiente fallo "+e.getMessage());
            }
        }
    }

}
