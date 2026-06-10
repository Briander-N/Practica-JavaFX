package com.example.practicajavafx2;

import javafx.application.Platform; // Necesario para esperar el renderizado
import javafx.fxml.FXML;
import javafx.fxml.Initializable; // Interfaz para ejecutar código al arrancar
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class CajeroController implements Initializable {

    //Labels
    @FXML
    public Label lblTituloCajero;
    @FXML
    public Label lblNombreCliente;
    @FXML
    public Label lblCedulaCliente;
    @FXML
    public Label lblTelefonoCliente;
    @FXML
    public Label lblDireccionCliente;

    //TextField
    @FXML
    public TextField txtNombreCliente;
    @FXML
    public TextField txtCedulaCliente;
    @FXML
    public TextField txtTelefonoCliente;
    @FXML
    public TextField txtDireccionCliente;

    // Método que se ejecuta automáticamente cuando se carga la vista FXML
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Ejecuta el código un instante después de que la ventana aparece en pantalla
        Platform.runLater(() -> {
            if (lblTituloCajero.getScene() != null) {
                // Inyectamos la hoja de estilos nativa de BootstrapFX
                lblTituloCajero.getScene().getStylesheets().add(
                        org.kordamp.bootstrapfx.BootstrapFX.bootstrapFXStylesheet()
                );
            }
        });
    }
}
