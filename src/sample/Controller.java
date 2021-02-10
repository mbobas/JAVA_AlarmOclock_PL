package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML private ComboBox comboBoxGodzina;
    @FXML private ComboBox comboBoxMinuta;
    @FXML private DatePicker dataPicker;
    @FXML private ComboBox comboBoxMelodia;
    @FXML private Slider vol;
    @FXML private RadioButton PN, WT, SR, CZ, PT, SO, NI;

    private String godzina, minuta, melodia;

    private LocalDate data;
    private int glosnosc;

    List<String> markedDays = new ArrayList<String>();

    @FXML
    void dodajGodzine(ActionEvent event) {
        godzina = (String) comboBoxGodzina.getValue();
        }
    @FXML
    void dodajMinute(ActionEvent event) {
        minuta = (String) comboBoxMinuta.getValue();
    }
    @FXML
    void dodajDate(ActionEvent event) {
        data = dataPicker.getValue();

    }
    @FXML
    void dodajMelodie(ActionEvent event) {
        melodia = (String) comboBoxMelodia.getValue();
    }
    @FXML
    void dodajVolume(ActionEvent event) {
        double glos = vol.getValue();
        glosnosc = (int)glos;
    }

    void dodajDzien2(ActionEvent event) {

        List<RadioButton> days = new ArrayList<RadioButton>();

        days.add(PN); days.add(WT);days.add(SR);
        days.add(CZ);days.add(PT); days.add(SO);days.add(NI);

        for (RadioButton d : days ) {
            if (d.isSelected()) {
                markedDays.add(String.valueOf(d.getText()));
            }
        }
    }


    @FXML
    protected void saveAndexitClick(ActionEvent event) {
        dodajVolume(event);
        dodajDzien2(event);
        System.out.print("Ustawiono Alarm! \n Godzina: "+ godzina + ":" +minuta + "\n Data: " + data +
            "\n Melodia: " + melodia + "\n Głośność: " + glosnosc + "\n Powtarzaj w dni: "
        );

        for (String s : markedDays) {
            System.out.print(s + " ");
        }

        Platform.exit();
    }
    @FXML
    protected void exitClick(ActionEvent event) {
        Platform.exit();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Godziny
        List<String> list1 = new ArrayList<String>();
        for (int i=0; i<=9; i++){
            String s = "0" + i;
            list1.add(s);
        }
        for (int i=10; i<=24; i++){
            list1.add(String.valueOf(i));
        }
        ObservableList obList = FXCollections.observableList(list1);
        comboBoxGodzina.getItems().clear();
        comboBoxGodzina.setItems(obList);

        //Minuty
        List<String> list2 = new ArrayList<String>();
        for (int i=0; i<=9; i++){
            String s = "0" + i;
            list2.add(s);
        }
        for (int i=10; i<=59; i++){
            list2.add(String.valueOf(i));
        }

        ObservableList obList2 = FXCollections.observableList(list2);
        comboBoxMinuta.getItems().clear();
        comboBoxMinuta.setItems(obList2);

        //Melodie
        List<String> listaMelodie = new ArrayList<String>();
        for (int i=0; i<=9; i++){
            String s = "Melodia" + i;
            listaMelodie.add(s);
        }

        ObservableList oblistaMelodie = FXCollections.observableList(listaMelodie);
        comboBoxMelodia.getItems().clear();
        comboBoxMelodia.setItems(oblistaMelodie);
        vol.setShowTickLabels(true);
    }
}
