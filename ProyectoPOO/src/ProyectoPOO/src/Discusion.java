package ProyectoPOO.src;

import java.io.IOException;
import java.net.URL;
import java.time.Clock;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Discusion {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Actividades1;

    @FXML
    private Button Lecturas1;

    @FXML
    private Button Salir;

    @FXML
    private Button agregarBtn;

    @FXML
    private TextArea comentarioSelecTxt;

    @FXML
    private TableColumn<ComentariosForo, String> comentarioTabla;

    @FXML
    private TextArea comentarioTxt;

    @FXML
    private TableColumn<ComentariosForo, LocalDate> fechaTabla;

    @FXML
    private Button iniciarSesion1;

    @FXML
    private Button instituciones;

    @FXML
    private Button nuevoBtn;

    @FXML
    private TableView<ComentariosForo> tableId;

    @FXML
    private TextField uSelecTxt;

    @FXML
    private TableColumn<ComentariosForo, String> usuarioTabla;

    @FXML
    private TextField usuarioTxt;

    @FXML
    void agregar(ActionEvent event) throws IOException {
	Clock clock = Clock.systemUTC();
        LocalDate date = LocalDate.now(clock);
        
        if(!comentarioTxt.getText().isEmpty() && !comentarioTxt.getText().isBlank()) {
            ComentariosForo comentario = new ComentariosForo("gua1234", comentarioTxt.getText(), date);
            if(comentario.insertarComentario()) {
                ObservableList<ComentariosForo> items = comentario.getComentarios();
                this.tableId.setItems(items);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Exito");
                alert.setContentText("Se incerto correctamente el comentario");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("No se inserto correctamente el comentario");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debe de llenar el campo de comentario");
            alert.showAndWait();
        }
    }

    @FXML
    void nuevoComentario(ActionEvent event) {
	    comentarioTxt.setText(""); // vacia el textfield 
    }

    @FXML
    void onPressActividades(ActionEvent event) {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("discusion.fxml"));
            Stage stage0 = (Stage) Actividades1.getScene().getWindow();
            Stage stage1 = new Stage();
            stage0.close();
            stage1.setScene(new Scene(root));
            stage1.show();
        }catch(Exception e){
            System.out.println("algo fallo: "+e.getMessage());
        }
    }

    @FXML
    void onPressIniciarSesion(ActionEvent event) {
	try
        {
            Parent root = FXMLLoader.load(getClass().getResource("paginainicial.fxml"));
            Stage stage0 = (Stage) iniciarSesion1.getScene().getWindow();
            Stage stage1 = new Stage();
            stage0.close();
            stage1.setScene(new Scene(root));
            stage1.show();
        }catch(Exception e){
            System.out.println("algo fallo: "+e.getMessage());
        }
    }

    @FXML
    void onPressLecturas(ActionEvent event) {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("lecprincipal.fxml"));
            Stage stage0 = (Stage) Lecturas1.getScene().getWindow();
            Stage stage1 = new Stage();
            stage0.close();
            stage1.setScene(new Scene(root));
            stage1.show();
        }catch(Exception e){
            System.out.println("algo fallo: "+e.getMessage());
        }
    }

    @FXML
    void onPressSalir(ActionEvent event) {
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
            System.out.println("algo fallo: "+e.getMessage());
        }
    }

    @FXML
    void seleccionar(MouseEvent event) {
	ComentariosForo comentario = this.tableId.getSelectionModel().getSelectedItem();
        if(comentario!=null) {
            this.uSelecTxt.setText(comentario.getNombre());
            this.comentarioSelecTxt.setText(comentario.getComentario());
        }
    }

    @FXML
    void initialize() throws IOException {        	
	    this.fechaTabla.setCellValueFactory(new PropertyValueFactory("fecha"));
        this.usuarioTabla.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.comentarioTabla.setCellValueFactory(new PropertyValueFactory("comentario"));
        ComentariosForo comentario = new ComentariosForo();
        ObservableList<ComentariosForo> items = comentario.getComentarios();
        this.tableId.setItems(items);
    }
}