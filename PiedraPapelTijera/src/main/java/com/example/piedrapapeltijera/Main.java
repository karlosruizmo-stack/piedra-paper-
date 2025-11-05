package com.example.piedrapapeltijera;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    Label lblResultado = new Label("Haz tu elección");
    Random random = new Random();

    @Override
    public void start(Stage stage) {
        Button btnPiedra = new Button("Piedra");
        Button btnPapel = new Button("Papel");
        Button btnTijera = new Button("Tijera");

        btnPiedra.setOnAction(e -> jugar("Piedra"));
        btnPapel.setOnAction(e -> jugar("Papel"));
        btnTijera.setOnAction(e -> jugar("Tijera"));

        VBox root = new VBox(10, lblResultado, btnPiedra, btnPapel, btnTijera);
        root.setStyle("-fx-padding: 20px; -fx-alignment: center;");

        Scene scene = new Scene(root, 300, 200);
        stage.setTitle("Piedra, Papel o Tijera");
        stage.setScene(scene);
        stage.show();
    }

    private void jugar(String opcionJugador) {
        int num = random.nextInt(3); // opción aleatoria de CPU
        String cpu;

        if (num == 0) {
            cpu = "Piedra";
        } else if (num == 1) {
            cpu = "Papel";
        } else {
            cpu = "Tijera";
        }

        String resultado;

        // comparaciones de victoria, empate o derrota
        if (opcionJugador.equals(cpu)) {
            resultado = "Empate";
        } else if (opcionJugador.equals("Piedra") && cpu.equals("Tijera")) {
            resultado = "Ganaste";
        } else if (opcionJugador.equals("Papel") && cpu.equals("Piedra")) {
            resultado = "Ganaste";
        } else if (opcionJugador.equals("Tijera") && cpu.equals("Papel")) {
            resultado = "Ganaste";
        } else {
            resultado = "Perdiste";
        }

        lblResultado.setText("Tú: " + opcionJugador + " | CPU: " + cpu + " → " + resultado);
    }

    public static void main(String[] args) {
        launch();
    }
}