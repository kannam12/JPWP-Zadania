package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import utils.Board;

public class Zadanie {
    @FXML
    BorderPane borderpane;


    /*
    a) Klasa Board to nasz uproszczony model kwadratowej planszy sapera
       składający się z tablicy dwuwymierowej Square[][] board, w której
       każdy kwadrat opisuje jedno pole na planszy i posiada parametr
       status, który mówi czy jest na nim mina(można sie do niego standardowo dostawać
       setterami i getterami co polecam czynić).
       Board ma parametry size(opisujący w ilości kwadratów długość boku) i
       bombsCount(opisujący ile bomb mam mieć plansza).

       Uzupełnij w klasie Board metodę setBombs, która odpowiednio rozmieści bomby
       (patrz komentarz w Board)

    b)  -Stwórz nowy plik "Zadanie.fxml". Dodaj w nim wskazanie na fxController
        do tej klasy (Zadanie.java). Gdy metoda initialize zapali się na żółto,
        znaczy, że kontroler jest poprawnie przypisany do pliku fxml
        Otwórz "Zadanie.fxml" i edytuj go tak
        aby składał się on z BorderPane'a.
        BorderPane'owi nadaj fx:id żeby móc się do niego odwołać tutaj, w kontrolerze.
        Zdefiniuj w kontrolerze odpowiednie pole odpowiadające BorderPane'owi.

        -Napisz metodę setButtons.
        Używając zagnieżdżonej pętli for(){for(){//instruction}} wygeneruj planszę
        ToggleButtonów, która będzie odpowiadała planszy board[][] z klasy Board.
        Każdemu buttonowi dodaj obsługe zdarzenia. (button.setOnMouseClicked(mouseEvent -> {//instructions})

        -Jeżeli na odpowiadającemu buttonowi kwadracie z board[][] będzie znajdowała się bomba
        wypisz tą informację w konsoli oraz uniemożliwi dalsze wciskanie przycisku(setDisable),
        oraz pokoloruj przycisk na czerwono.

       -Natomiast, jeżeli nie to niech button się "odklikuje". (setSelected(false))
        Zadbaj by buttony miały wymiar 25x25 oraz by cały grid Pane był umieszczony na środku
        planszy.

        -Każdy button dodawaj w pętli do GridPane'a. Metoda gridpane.add(obiekt, wiersz, kolumna).
        Po skończeniu pętli dodaj cały GridPane do środka BorderPane'a.


     */

    public void initialize() {
        setButtons();
    }

    private void setButtons() {
        int size = 10;
        Board board = new Board(size, 20);
        board.printBoard();

        GridPane gridPane = new GridPane();

        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++) {
                ToggleButton toggleButton = new ToggleButton();
                int i1 = i;
                int j1 = j;

                toggleButton.setMinSize(25, 25);
                toggleButton.setOnMouseClicked(mouseEvent -> {

                    if (board.getBoard()[i1][j1].getStatus().equals("o")) {
                        System.out.println("Natrafiono na bombę");
                        toggleButton.setDisable(true);
                        toggleButton.setStyle("-fx-background-color: red");
                    } else {
                        toggleButton.setSelected(false);
                    }
                });

                gridPane.add(toggleButton, i, j);
            }
        }
        borderpane.setCenter(gridPane);
    }
}
