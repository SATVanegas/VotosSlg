package com.example.notas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Button Vt1;
    @FXML
    private Button Vt2;
    @FXML
    private Button Vt3;
    @FXML
    private Button Vt4;
    @FXML
    private Button Vt5;
    @FXML
    private Button Vtb;

    private int votosVt1 = 0;
    private int votosVt2 = 0;
    private int votosVt3 = 0;
    private int votosVt4 = 0;
    private int votosVt5 = 0;
    private int votosBlanco = 0;

    public void initialize() {
        Vt1.setOnAction(e -> onVt1ButtonClick());
        Vt2.setOnAction(e -> onVt2ButtonClick());
        Vt3.setOnAction(e -> onVt3ButtonClick());
        Vt4.setOnAction(e -> onVt4ButtonClick());
        Vt5.setOnAction(e -> onVt5ButtonClick());
        Vtb.setOnAction(e -> onVtbButtonClick());
        guardarVotos();
    }

    @FXML
    private void onVt1ButtonClick(){
        System.out.println("Hello1");
        mostrarVentanaEmergente();
    }
    @FXML
    private void onVt2ButtonClick(){
        System.out.println("Hello2");
        votosVt2 ++ ;
        guardarVotos();
    }
    @FXML
    private void onVt3ButtonClick(){
        System.out.println("Hello3");
        votosVt3 ++ ;
        guardarVotos();
    }
    @FXML
    private void onVt4ButtonClick(){
        System.out.println("Hello4");
        votosVt4 ++ ;
        guardarVotos();
    }
    @FXML
    private void onVt5ButtonClick(){
        System.out.println("Hello5");
        votosVt5 ++ ;
        guardarVotos();
    }
    @FXML
    private void onVtbButtonClick(){
        System.out.println("Hello6");
        votosBlanco ++ ;
        guardarVotos();
    }

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void onAceptarButtonClick() {
        votosVt1++;
        guardarVotos();
        System.out.println("Se ha presionado Aceptar");
        // Cierra la ventana emergente
        stage.close();
    }

    @FXML
    private void onCancelarButtonClick() {
        // Cierra la ventana emergente sin realizar ninguna acción
        stage.close();
    }

    @FXML
    private void mostrarVentanaEmergente() {
        try {
            // Carga el archivo FXML de la ventana emergente
            FXMLLoader loader = new FXMLLoader(getClass().getResource("popup.fxml"));
            Parent root = loader.load();

            // Crea una nueva escena
            Scene scene = new Scene(root);

            // Configura el escenario de la ventana emergente
            Stage popupStage = new Stage();
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setTitle("Ventana Emergente");
            popupStage.setScene(scene);

            // Establece el controlador para la ventana emergente
            HelloController controller = loader.getController();
            controller.setStage(popupStage);

            // Muestra la ventana emergente
            popupStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void guardarVotos() {
        java.lang.String filePath = System.getProperty("user.dir") + "/votos.txt";
        System.out.println("Ruta del archivo: " + filePath);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("votos1.txt"))) {
            writer.write("vt1 = " + votosVt1 + "\n");
            writer.write("vt2 = " + votosVt2 + "\n");
            writer.write("vt3 = " + votosVt3 + "\n");
            writer.write("vt4 = " + votosVt4 + "\n");
            writer.write("vt5 = " + votosVt5 + "\n");
            writer.write("votos en blanco = " + votosBlanco + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}