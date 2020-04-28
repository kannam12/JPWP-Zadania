package com.company;

import java.util.Random;
import javafx.scene.input.MouseEvent;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class KolkoKrzyzyk extends Application {

    Scene scene;
    Stage window;
    Label label1,label2;
    Button button;
    Pane stackPane;
    boolean tura;
    int ostatnieKolo[];
    int licznikZwyciestw,licznikZwyciestw2;
    Pole[][] tabPol;
    Random random;

    public KolkoKrzyzyk() {
        tabPol = new Pole[3][3];
        tabPol[0][0] = new Pole(0, 0, 3, false, 3);
        tabPol[0][1] = new Pole(0, 1, 2, false, 2);
        tabPol[0][2] = new Pole(0, 2, 3, false, 3);

        tabPol[1][0] = new Pole(1, 0, 2, false, 2);
        tabPol[1][1] = new Pole(1, 1, 4, false, 4);
        tabPol[1][2] = new Pole(1, 2, 2, false, 2);

        tabPol[2][0] = new Pole(2, 0, 3, false, 3);
        tabPol[2][1] = new Pole(2, 1, 2, false, 2);
        tabPol[2][2] = new Pole(2, 2, 3, false, 3);

        tura = false;
        ostatnieKolo = new int[2];
        licznikZwyciestw = 0;
        licznikZwyciestw2 = 0;
        random = new Random();
    }

    public void jeszczeRaz() {
        tabPol = new Pole[3][3];
        tabPol[0][0] = new Pole(0, 0, 3, false, 3);
        tabPol[0][1] = new Pole(0, 1, 2, false, 2);
        tabPol[0][2] = new Pole(0, 2, 3, false, 3);

        tabPol[1][0] = new Pole(1, 0, 2, false, 2);
        tabPol[1][1] = new Pole(1, 1, 4, false, 4);
        tabPol[1][2] = new Pole(1, 2, 2, false, 2);

        tabPol[2][0] = new Pole(2, 0, 3, false, 3);
        tabPol[2][1] = new Pole(2, 1, 2, false, 2);
        tabPol[2][2] = new Pole(2, 2, 3, false, 3);

        tura = false;
        ostatnieKolo = new int[2];
        random = new Random();
    }

    private int[] losoweWolne() {
        int x, y;
        while (true) {
            x = random.nextInt(3);
            y = random.nextInt(3);
            if (tabPol[x][y].isObecnosc() == false) {
                break;
            }
        }
        int tab[] = new int[2];
        tab[0] = x;
        tab[1] = y;
        return tab;
    }

    public int[] czyWygralem() {
        int x = ostatnieKolo[0];
        int y = ostatnieKolo[1];
        boolean jeden = false;
        boolean dwa = false;
        int oddaj[] = new int[2];
        int przypadek = tabPol[x][y].getIdWagi();

        if (przypadek == 3) {

            for (int i = 0; i < 2; i++) {
                System.out.println("X: " + x);
                if (ostatnieKolo[0] == 2) {
                    x--;
                } else {
                    x++;
                }
                if (tabPol[x][ostatnieKolo[1]].isObecnosc() == true && tabPol[x][ostatnieKolo[1]].getZnak().equals("O") == true) {
                    jeden = true;
                }
                if (tabPol[x][ostatnieKolo[1]].isObecnosc() == false) {
                    dwa = true;
                    oddaj[0] = x;
                }
            }
            x = ostatnieKolo[0];
            if (jeden == true && dwa == true) {
                oddaj[1] = ostatnieKolo[1];
                return oddaj;
            } else {
                oddaj[0] = -1;
                jeden = false;
                dwa = false;
            }

            for (int i = 0; i < 2; i++) {
                if (ostatnieKolo[1] == 2) {
                    y--;
                } else {
                    y++;
                }
                if (tabPol[ostatnieKolo[0]][y].isObecnosc() == true && tabPol[ostatnieKolo[0]][y].getZnak().equals("O")) {
                    jeden = true;
                }
                if (tabPol[ostatnieKolo[0]][y].isObecnosc() == false) {
                    dwa = true;
                    oddaj[1] = y;
                }
            }
            y = ostatnieKolo[1];
            if (jeden == true && dwa == true) {
                oddaj[0] = ostatnieKolo[0];
                return oddaj;
            } else {
                oddaj[1] = -1;
                jeden = false;
                dwa = false;
            }

            for (int i = 0; i < 2; i++) {
                if (ostatnieKolo[0] == 2) {
                    x--;
                } else {
                    x++;
                }
                if (ostatnieKolo[1] == 2) {
                    y--;
                } else {
                    y++;
                }
                if (tabPol[x][y].isObecnosc() == true && tabPol[x][y].getZnak().equals("O")) {
                    jeden = true;
                }
                if (tabPol[x][y].isObecnosc() == false) {
                    dwa = true;
                    oddaj[0] = x;
                    oddaj[1] = y;
                }
            }
            if (jeden == true && dwa == true) {
                return oddaj;
            }
        }

        if (przypadek == 2) {
            if (x == 0 && y == 1) {
                for (int i = 0; i < 2; i++) {
                    x++;
                    if (tabPol[x][y].isObecnosc() == true && tabPol[x][y].getZnak().equals("O") == true) {
                        jeden = true;
                    }
                    if (tabPol[x][y].isObecnosc() == false) {
                        oddaj[0] = x;
                        oddaj[1] = y;
                        dwa = true;
                    }
                }
                x = ostatnieKolo[0];
                if (jeden == true && dwa == true) {
                    return oddaj;
                } else {
                    oddaj[0] = -1;
                    oddaj[1] = -1;
                }

                if(tabPol[x][y-1].isObecnosc() == true && tabPol[x][y-1].getZnak().equals("O")== true && tabPol[x][y+1].isObecnosc() == false){
                    oddaj[0] = x;
                    oddaj[1] = y+1;
                    return oddaj;
                }
                else if(tabPol[x][y+1].isObecnosc() == true && tabPol[x][y+1].getZnak().equals("O")== true && tabPol[x][y-1].isObecnosc() == false){
                    oddaj[0] = x;
                    oddaj[1] = y-1;
                    return oddaj;
                }

            } else if (x == 1 & y == 0) {

                for (int i = 0; i < 2; i++) {
                    y++;
                    if (tabPol[x][y].isObecnosc() == true && tabPol[x][y].getZnak().equals("O") == true) {
                        jeden = true;
                    }
                    if (tabPol[x][y].isObecnosc() == false) {
                        oddaj[0] = x;
                        oddaj[1] = y;
                        dwa = true;
                    }
                }
                y = ostatnieKolo[1];
                if (jeden == true && dwa == true) {
                    return oddaj;
                } else {
                    oddaj[0] = -1;
                    oddaj[1] = -1;
                }
                if(tabPol[x+1][y].isObecnosc() == true && tabPol[x+1][y].getZnak().equals("O")== true && tabPol[x-1][y].isObecnosc() == false){
                    oddaj[0] = x-1;
                    oddaj[1] = y;
                    return oddaj;
                }
                else if(tabPol[x-1][y].isObecnosc() == true && tabPol[x-1][y].getZnak().equals("O")== true && tabPol[x+1][y].isObecnosc() == false){
                    oddaj[0] = x+1;
                    oddaj[1] = y;
                    return oddaj;
                }
            } else if (x == 2 && y == 1) {
                for (int i = 0; i < 2; i++) {
                    x--;
                    if (tabPol[x][y].isObecnosc() == true && tabPol[x][y].getZnak().equals("O") == true) {
                        jeden = true;
                    }
                    if (tabPol[x][y].isObecnosc() == false) {
                        oddaj[0] = x;
                        oddaj[1] = y;
                        dwa = true;
                    }
                }
                x = ostatnieKolo[0];
                if (jeden == true && dwa == true) {
                    return oddaj;
                } else {
                    oddaj[0] = -1;
                    oddaj[1] = -1;
                }
                if(tabPol[x][y-1].isObecnosc() == true && tabPol[x][y-1].getZnak().equals("O")== true && tabPol[x][y+1].isObecnosc() == false){
                    oddaj[0] = x;
                    oddaj[1] = y+1;
                    return oddaj;
                }
                else if(tabPol[x][y+1].isObecnosc() == true && tabPol[x][y+1].getZnak().equals("O")== true && tabPol[x][y-1].isObecnosc() == false){
                    oddaj[0] = x;
                    oddaj[1] = y-1;
                    return oddaj;
                }

            } else {//x==1 && y ==2

                for (int i = 0; i < 2; i++) {
                    y--;
                    if (tabPol[x][y].isObecnosc() == true && tabPol[x][y].getZnak().equals("O") == true) {
                        jeden = true;
                    }
                    if (tabPol[x][y].isObecnosc() == false) {
                        oddaj[0] = x;
                        oddaj[1] = y;
                        dwa = true;
                    }
                }
                y = ostatnieKolo[1];
                if (jeden == true && dwa == true) {
                    return oddaj;
                } else {
                    oddaj[0] = -1;
                    oddaj[1] = -1;
                }
                if(tabPol[x+1][y].isObecnosc() == true && tabPol[x+1][y].getZnak().equals("O")== true && tabPol[x-1][y].isObecnosc() == false){
                    oddaj[0] = x-1;
                    oddaj[1] = y;
                    return oddaj;
                }
                else if(tabPol[x-1][y].isObecnosc() == true && tabPol[x-1][y].getZnak().equals("O")== true && tabPol[x+1][y].isObecnosc() == false){
                    oddaj[0] = x+1;
                    oddaj[1] = y;
                    return oddaj;
                }
            }
        }
        oddaj[0] = -1;
        oddaj[1] = -1;
        return oddaj;
    }

    private void drukujWagi() {
        System.out.println(tabPol[0][0].getWaga() + " " + tabPol[1][0].getWaga() + " " + tabPol[2][0].getWaga());
        System.out.println(tabPol[0][1].getWaga() + " " + tabPol[1][1].getWaga() + " " + tabPol[2][1].getWaga());
        System.out.println(tabPol[0][2].getWaga() + " " + tabPol[1][2].getWaga() + " " + tabPol[2][2].getWaga());
    }

    public int[] dajPoleNajwazniejsze() {
        int naj[] = new int[2];
        int tabPowtorkiX[] = new int[9];
        int tabPowtorkiY[] = new int[9];
        int iterator = 0;
        int licznik = 0;
        int losowyStart[] = losoweWolne();

        naj[0] = losowyStart[0];
        naj[1] = losowyStart[1];
        //  System.out.println("LosowyStart: naj[0]= " + naj[0] + " naj[1]= " + naj[1]);
        //System.out.println("WagaLosowego startu: " + tabPol[naj[0]][naj[1]].getWaga());
        drukujWagi();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabPol[i][j].getWaga() > tabPol[naj[0]][naj[1]].getWaga() && tabPol[i][j].isObecnosc() == false) {
                    naj[0] = i;
                    naj[1] = j;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabPol[i][j].getWaga() == tabPol[naj[0]][naj[1]].getWaga() && tabPol[i][j].isObecnosc() == false) {
                    // System.out.println("WEW x: "+tabPol[i][j].getX()+" Y: "+tabPol[i][j].getY()+" obecnosc: "+tabPol[i][j].isObecnosc());
                    //System.out.println(tabPol[i][j].getWaga() > tabPol[naj[0]][naj[1]].getWaga());
                    //System.out.println(tabPol[i][j].isObecnosc() == false);
                    tabPowtorkiX[iterator] = i;
                    tabPowtorkiY[iterator] = j;
                    iterator++;
                    licznik++;
                }
            }
        }
        if (licznik > 1) {
            int losowa = random.nextInt(licznik);
            naj[0] = tabPowtorkiX[losowa];
            naj[1] = tabPowtorkiY[losowa];
        }
        System.out.println("Najważniejsze pole: X: "+naj[0]+" Y: "+naj[1]);
        return naj;
    }

    public void zmienWageWLini(Pole polePodane) {
        drukujWagi();
        int przypadek = polePodane.getIdWagi();
        int x = polePodane.getX();
        int y = polePodane.getY();
        if (przypadek == 3) {
            int wiecej = 1;

            for (int i = 0; i < 2; i++) {
                System.out.println("X: " + x);
                if (polePodane.getX() == 2) {
                    x--;
                } else {
                    x++;
                }
                if (tabPol[x][polePodane.getY()].isObecnosc() == true && tabPol[x][polePodane.getY()].getZnak().equals("X") == true) {
                    System.out.println("eloi " + x);
                    wiecej = 3;
                }
            }

            x = polePodane.getX();
            for (int i = 0; i < 2; i++) {
                if (polePodane.getX() == 2) {
                    x--;
                } else {
                    x++;
                }
                tabPol[x][polePodane.getY()].setWaga(tabPol[x][polePodane.getY()].getWaga() + 1 * wiecej);
            }
            wiecej = 1;

            for (int i = 0; i < 2; i++) {
                if (polePodane.getY() == 2) {
                    y--;
                } else {
                    y++;
                }
                if (tabPol[polePodane.getX()][y].isObecnosc() == true && tabPol[polePodane.getX()][y].getZnak().equals("X")) {
                    wiecej = 3;
                }
            }
            y = polePodane.getY();

            for (int i = 0; i < 2; i++) {
                if (polePodane.getY() == 2) {
                    y--;
                } else {
                    y++;
                }
                tabPol[polePodane.getX()][y].setWaga(tabPol[polePodane.getX()][y].getWaga() + 1 * wiecej);
            }

            wiecej = 1;
            x = polePodane.getX();
            y = polePodane.getY();
            for (int i = 0; i < 2; i++) {
                if (polePodane.getX() == 2) {
                    x--;
                } else {
                    x++;
                }
                if (polePodane.getY() == 2) {
                    y--;
                } else {
                    y++;
                }
                if (tabPol[x][y].isObecnosc() == true && tabPol[x][y].getZnak().equals("X")) {
                    wiecej = 3;
                }
            }
            x = polePodane.getX();
            y = polePodane.getY();
            for (int i = 0; i < 2; i++) {
                if (polePodane.getX() == 2) {
                    x--;
                } else {
                    x++;
                }
                if (polePodane.getY() == 2) {
                    y--;
                } else {
                    y++;
                }
                tabPol[x][y].setWaga(tabPol[x][y].getWaga() + 1 * wiecej);
            }
        }

        if (przypadek == 2) {
            int wiecej = 1;
            if (x == 0 && y == 1) {
                if (tabPol[x][y + 1].isObecnosc() == true && tabPol[x][y + 1].getZnak().equals("X") == true) {
                    wiecej = 3;
                }
                if (tabPol[x][y - 1].isObecnosc() == true && tabPol[x][y - 1].getZnak().equals("X") == true) {
                    wiecej = 3;
                }
                tabPol[x][y - 1].setWaga(tabPol[x][y - 1].getWaga() + 1 * wiecej);
                tabPol[x][y + 1].setWaga(tabPol[x][y + 1].getWaga() + 1 * wiecej);
                wiecej = 1;
                for (int i = 0; i < 2; i++) {
                    x++;
                    if (tabPol[x][y].isObecnosc() == true && tabPol[x][y].getZnak().equals("X") == true) {
                        wiecej = 3;
                    }
                }
                x = polePodane.getX();
                for (int i = 0; i < 2; i++) {
                    x++;
                    tabPol[x][y].setWaga(tabPol[x][y].getWaga() + 1 * wiecej);
                }
            } else if (x == 1 & y == 0) {
                if (tabPol[x + 1][y].isObecnosc() == true && tabPol[x + 1][y].getZnak().equals("X") == true) {
                    wiecej = 3;
                }
                if (tabPol[x - 1][y].isObecnosc() == true && tabPol[x - 1][y].getZnak().equals("X") == true) {
                    wiecej = 3;
                }
                tabPol[x - 1][y].setWaga(tabPol[x - 1][y].getWaga() + 1 * wiecej);
                tabPol[x + 1][y].setWaga(tabPol[x + 1][y].getWaga() + 1 * wiecej);
                wiecej = 1;
                for (int i = 0; i < 2; i++) {
                    y++;
                    if (tabPol[x][y].isObecnosc() == true && tabPol[x][y].getZnak().equals("X") == true) {
                        wiecej = 3;
                    }
                }
                y = polePodane.getY();
                for (int i = 0; i < 2; i++) {
                    y++;
                    tabPol[x][y].setWaga(tabPol[x][y].getWaga() + 1 * wiecej);
                }

            } else if (x == 2 && y == 1) {
                if (tabPol[x][y + 1].isObecnosc() == true && tabPol[x][y + 1].getZnak().equals("X") == true) {
                    wiecej = 3;
                }
                if (tabPol[x][y - 1].isObecnosc() == true && tabPol[x][y - 1].getZnak().equals("X") == true) {
                    wiecej = 3;
                }
                tabPol[x][y - 1].setWaga(tabPol[x][y - 1].getWaga() + 1 * wiecej);
                tabPol[x][y + 1].setWaga(tabPol[x][y + 1].getWaga() + 1 * wiecej);
                wiecej = 1;
                for (int i = 0; i < 2; i++) {
                    x--;
                    if (tabPol[x][y].isObecnosc() == true && tabPol[x][y].getZnak().equals("X") == true) {
                        wiecej = 3;
                    }
                }
                x = polePodane.getX();
                for (int i = 0; i < 2; i++) {
                    x--;
                    tabPol[x][y].setWaga(tabPol[x][y].getWaga() + 1 * wiecej);
                }
            } else {//x==1 && y ==2
                if (tabPol[x + 1][y].isObecnosc() == true && tabPol[x + 1][y].getZnak().equals("X") == true) {
                    wiecej = 3;
                }
                if (tabPol[x - 1][y].isObecnosc() == true && tabPol[x - 1][y].getZnak().equals("X") == true) {
                    wiecej = 3;
                }
                tabPol[x - 1][y].setWaga(tabPol[x - 1][y].getWaga() + 1 * wiecej);
                tabPol[x + 1][y].setWaga(tabPol[x + 1][y].getWaga() + 1 * wiecej);
                wiecej = 1;
                for (int i = 0; i < 2; i++) {
                    y--;
                    if (tabPol[x][y].isObecnosc() == true && tabPol[x][y].getZnak().equals("X") == true) {
                        wiecej = 3;
                    }
                }
                y = polePodane.getY();
                for (int i = 0; i < 2; i++) {
                    y--;
                    tabPol[x][y].setWaga(tabPol[x][y].getWaga() + 1 * wiecej);
                }
            }
        }
    }

    public Line[] DajLinie(int x, int y) {
        Line linia1 = new Line(x * 100 + 10, y * 100 + 10, x * 100 + 90, y * 100 + 90);
        Line linia2 = new Line(x * 100 + 90, y * 100 + 10, x * 100 + 10, y * 100 + 90);
        /*
        linia1.setStyle("-fx-stroke: #ffffff;");
        linia1.setStyle("-fx-stroke-width: 2px;");
        linia2.setStyle("-fx-stroke: #ffffff;");
        linia2.setStyle("-fx-stroke-width: 2px;");
*/

        Line[] tab = {linia1, linia2};
        return tab;
    }

    public Circle dajKolo(int x, int y) {
        Circle circle = new Circle(x * 100 + 50, y * 100 + 50, 40);
        return circle;
    }

    public void zmienTure() {
        boolean czyMozna = false;
        for(int i =0;i<3;i++){
            for(int j = 0;j<3;j++){
                if(tabPol[i][j].isObecnosc() == false)czyMozna = true;
            }
        }
        if(czyMozna == true){
            tura = !tura;
            if (tura == true) {
                komputerOdpowiedz();
            }
        }
    }

    public void komputerOdpowiedz() {

        System.out.println("OstatnieKoloX: "+ostatnieKolo[0]);
        System.out.println("OstatnieKoloY: "+ostatnieKolo[1]);
        int zwyciestwo[] = czyWygralem();
        System.out.println("zwyciestwo[0]: "+zwyciestwo[0]);
        System.out.println("zwyciestwo[1]: "+zwyciestwo[1]);
        System.out.println("OstatnieKoloX: "+ostatnieKolo[0]);
        System.out.println("OstatnieKoloY: "+ostatnieKolo[1]);
        if (zwyciestwo[0] != -1 && zwyciestwo[1] != -1) {
            stackPane.getChildren().add(dajKolo(zwyciestwo[0], zwyciestwo[1]));
            System.out.println("game over ");
            licznikZwyciestw++;
            label1.setText("Komputer: "+licznikZwyciestw);
            System.out.println("LicznikZwyciestw: "+licznikZwyciestw);
        } else {
            int tab[] = dajPoleNajwazniejsze();
            tabPol[tab[0]][tab[1]].setObecnosc(true);
            tabPol[tab[0]][tab[1]].setZnak("O");
            stackPane.getChildren().add(dajKolo(tab[0], tab[1]));
            ostatnieKolo[0] = tab[0];
            ostatnieKolo[1] = tab[1];
            zmienTure();
        }
    }

    public void rysujSiatke() {
        stackPane = new Pane();
        label1 = new Label("Komputer: "+licznikZwyciestw);
        label1.setLayoutX(10);
        label1.setLayoutY(320);
        label1.setFont(new Font("TimesRoman",15));
        label2 = new Label("Ja:              "+licznikZwyciestw2);
        label2.setLayoutX(10);
        label2.setLayoutY(350);
        label2.setFont(new Font("TimesRoman",15));
        button = new Button("restart");
        button.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                jeszczeRaz();
                stackPane = new Pane();
                stackPane.getChildren().addAll(button,label1,label2);
                scene.setRoot(stackPane);
            }
        });
        button.setLayoutX(120);
        button.setLayoutY(350);
        button.setId("myd");

        stackPane.getChildren().addAll(button,label1,label2);
        scene = new Scene(stackPane, 290, 390);
        System.out.println("ścieżkaString: "+getClass().getResource("/kolorki.css").toString());
        System.out.println("ścieżkaPath: "+getClass().getResource("/kolorki.css").getPath());
        System.out.println("ścieżkaExternal: "+getClass().getResource("/kolorki.css").toExternalForm());

        scene.getStylesheets().add(getClass().getResource("/kolorki.css").toExternalForm());

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setResizable(false);
        rysujSiatke();
        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                double x = e.getX();
                double y = e.getY();
                if (x <= 300 && y <= 300) {
                    double a = x * 0.01;
                    double b = y * 0.01;
                    int Xv2 = (int) a;
                    int Yv2 = (int) b;

                    if (tabPol[Xv2][Yv2].isObecnosc() == false && tura == false) {
                        Line[] tab = DajLinie(Xv2, Yv2);
                        tabPol[Xv2][Yv2].setObecnosc(true);
                        tabPol[Xv2][Yv2].setZnak("X");
                        System.out.println("x:"+tabPol[Xv2][Yv2].getX()+" y: "+tabPol[Xv2][Yv2].getY()+" obecnosc: "+tabPol[Xv2][Yv2].isObecnosc()+" znak: "+tabPol[Xv2][Yv2].getZnak());
                        stackPane.getChildren().addAll(tab[0], tab[1]);
                        zmienWageWLini(tabPol[Xv2][Yv2]);
                        zmienTure();
                    }
                }
            }
        });

        window.setScene(scene);
        window.show();
    }
    public static void main(String[] args) {

        launch(args);
        System.out.println("XD");
    }
}

