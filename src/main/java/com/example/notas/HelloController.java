package com.example.notas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Optional;

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
    @FXML
    private Button MostrarVotos;
    @FXML
    private Button CloseMesa;



    private int votosVt1 = 0;
    private int votosVt2 = 0;
    private int votosVt3 = 0;
    private int votosVt4 = 0;
    private int votosVt5 = 0;
    private int votosBlanco = 0;

    public Label Vt01;
    public Label Vt02;
    public Label Vt03;
    public Label Vt04;
    public Label Vt05;
    public Label Vt06;

    public void initialize() {
        Vt1.setOnAction(e -> onVt1ButtonClick());
        Vt2.setOnAction(e -> onVt2ButtonClick());
        Vt3.setOnAction(e -> onVt3ButtonClick());
        Vt4.setOnAction(e -> onVt4ButtonClick());
        Vt5.setOnAction(e -> onVt5ButtonClick());
        Vtb.setOnAction(e -> onVtbButtonClick());
        MostrarVotos.setOnAction(e -> onMostrarVotosButtonClick());
        CloseMesa.setOnAction(e -> onCloseButtonClick());
        Vt01.setText("Votos por el 01: " + votosVt1);
        Vt02.setText("Votos por el 02: " + votosVt2);
        Vt03.setText("Votos por el 03: " + votosVt3);
        Vt04.setText("Votos por el 04: " + votosVt4);
        Vt05.setText("Votos por el 05: " + votosVt5);
        Vt06.setText("Votos En Blanco: " + votosBlanco);
        guardarVotos();
    }


    private void onCloseButtonClick() {
      boolean vl =displayMessage("Desea cerrar la mesa de votacion","La mesa quedara inhabilitada","Se procedera al liberar el boton informe en caso de dar aceptar");
      if (vl){
          MostrarVotos.setVisible(true);
          Vt1.setVisible(false);
          Vt2.setVisible(false);
          Vt3.setVisible(false);
          Vt4.setVisible(false);
          Vt5.setVisible(false);
          Vtb.setVisible(false);
      }else{
          System.out.println("Cancel");
      }
    }

    @FXML
    private void onMostrarVotosButtonClick(){
        mostrarEtiquetas();
    }
    @FXML
    private void onVt1ButtonClick(){
        boolean vl = displayMessage("Confirmar","Desea votar por el 01","Elija Una opcinar para continuar");
        System.out.println("Hello1");
        if(vl){
            guardarVotos();
            votosVt1 ++ ;
            Vt01.setText("Votos por el 01: " + votosVt1);
        }else{
            System.out.println("Hello1");
        }
    }
    @FXML
    private void onVt2ButtonClick(){
        boolean vl = displayMessage("Confirmat","Desea votar por el 02","Elija Una opcinar para continuar");
        System.out.println("Hello2");
        if(vl){
            guardarVotos();
            votosVt2 ++ ;
            Vt02.setText("Votos por el 02: " + votosVt2);
        }else{
            System.out.println("Hello2");
        }
    }

    @FXML
    private void onVt3ButtonClick(){
        boolean vl = displayMessage("Confirmat","Desea votar por el 03","Elija Una opcinar para continuar");
        System.out.println("Hello3");
        if(vl){
            votosVt3 ++ ;
            guardarVotos();
            Vt03.setText("Votos por el 03: " + votosVt3);
        }else{
            System.out.println("Hello3");
        }
    }

    @FXML
    private void onVt4ButtonClick(){
        boolean vl = displayMessage("Confirmat","Desea votar por el 04","Elija Una opcinar para continuar");
        System.out.println("Hello4");
        if(vl){
            guardarVotos();
            votosVt4 ++ ;
            Vt04.setText("Votos por el 04: " + votosVt4);
        }else{
            System.out.println("Hello4");
        }
    }

    @FXML
    private void onVt5ButtonClick(){
        boolean vl = displayMessage("Confirmat","Desea votar por el 05","Elija Una opcinar para continuar");
        if(vl){
            guardarVotos();
            votosVt5 ++ ;
            Vt05.setText("Votos por el 05: " + votosVt5);
        }else{
            System.out.println("Hello5");
        }
    }
    @FXML
    private void onVtbButtonClick(){
        boolean vl = displayMessage("Confirmar","Desea votar en blanco","Elija Una opcinar para continuar");
        System.out.println("Hello6");
        if(vl){
            guardarVotos();
            votosBlanco ++ ;
            Vtb.setText("Votos en blanco: " + votosBlanco);
        }else{
            System.out.println("Hello6");
        }
    }
    @FXML
    private void mostrarEtiquetas() {
        Vt01.setVisible(true);
        Vt03.setVisible(true);
        Vt04.setVisible(true);
        Vt05.setVisible(true);
        Vt06.setVisible(true);
        Vt02.setVisible(true);
    }

    public static boolean displayMessage(String title, String headerText, String content) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(content);
        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == ButtonType.OK;
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