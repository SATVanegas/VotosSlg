package com.example.notas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
    @FXML
    private Button MostrarVotos;

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
        Vt01.setText("01: " + votosVt1);
        Vt02.setText("02: " + votosVt2);
        Vt03.setText("03: " + votosVt3);
        Vt04.setText("04: " + votosVt4);
        Vt05.setText("05: " + votosVt5);
        Vt06.setText("06: " + votosBlanco);
        guardarVotos();
    }

    @FXML
    private void onMostrarVotosButtonClick(){
        mostrarEtiquetas();
    }
    @FXML
    private void onVt1ButtonClick(){
        System.out.println("Hello1");
        votosVt1++;
        guardarVotos();
        Vt01.setText("01: " + votosVt1);
    }
    @FXML
    private void onVt2ButtonClick(){
        System.out.println("Hello2");
        votosVt2 ++ ;
        guardarVotos();
        Vt02.setText("01: " + votosVt2);
    }
    @FXML
    private void onVt3ButtonClick(){
        System.out.println("Hello3");
        votosVt3 ++ ;
        guardarVotos();
        Vt03.setText("01: " + votosVt3);
    }
    @FXML
    private void onVt4ButtonClick(){
        System.out.println("Hello4");
        votosVt4 ++ ;
        guardarVotos();
        Vt04.setText("01: " + votosVt4);
    }
    @FXML
    private void onVt5ButtonClick(){
        System.out.println("Hello5");
        votosVt5 ++ ;
        displayMessage("Confirmat","Desea votar por el 05","Gay");
        guardarVotos();
        Vt05.setText("05: " + votosVt5);


    }
    @FXML
    private void onVtbButtonClick(){
        System.out.println("Hello6");
        votosBlanco ++ ;
        guardarVotos();
        Vt06.setText("Blanco: " + votosBlanco);
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

    public static void displayMessage(String title, String headerText, String content) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(content);
        alert.showAndWait();;
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