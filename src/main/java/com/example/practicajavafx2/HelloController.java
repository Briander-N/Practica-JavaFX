package com.example.practicajavafx2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    private final String usuarioAdmin = "Admin";
    private final String claveAdmin = "Admin";

    private final String usuarioCajero = "Cajero";
    private final String claveCajero = "Cajero";

    // Labels
    @FXML
    private Label lblTitulo;

    @FXML
    private Label lblUsuario;

    @FXML
    private Label lblContrasena;

    @FXML
    private Label lblValidacion;

    // TextFields
    @FXML
    private TextField txtUsuario;

    @FXML
    private TextField txtContrasena;

    //Combo Box

    @FXML
    private ComboBox<String> cbxRol;

    //Llenar el ComboBox
    @FXML
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        cbxRol.getItems().add("Administrador");
        cbxRol.getItems().add("Cajero");
    }


    @FXML
    public void validarCredenciales() {

        String usuarioIngresado = txtUsuario.getText().trim();
        String claveIngresada = txtContrasena.getText().trim();

        if (usuarioIngresado.equals(usuarioAdmin)
                && claveIngresada.equals(claveAdmin)) {

            lblValidacion.setText("ACCESO CORRECTO!");
            cambiarVentana("Administrador.fxml", "Administrador");

        } else if (usuarioIngresado.equals(usuarioCajero)
                && claveIngresada.equals(claveCajero)) {

            lblValidacion.setText("ACCESO CORRECTO!");
            cambiarVentana("Cajero.fxml", "Cajero");

        } else {

            lblValidacion.setText("ACCESO INCORRECTO!");
        }
    }
    @FXML
    private void cambiarVentana(String archivoFXML, String titulo) {

        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(archivoFXML)
            );

            Parent root = loader.load();

            Stage stage = (Stage) txtUsuario.getScene().getWindow();

            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle(titulo);
            stage.show();

        } catch (IOException e) {

            lblValidacion.setText("Error al cargar: " + archivoFXML);
            e.printStackTrace();
        }
    }

    @FXML
    public void salirDelPrograma(){
        System.exit(0);
    }
}