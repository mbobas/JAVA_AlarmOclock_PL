package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {



    @FXML private ComboBox comboBoxGodzina;
    @FXML private ComboBox comboBoxMinuta;
    @FXML private DatePicker dataPicker;

    private String godzina, minuta, dni_tygodnia, czyPotwarzaj, glosnosc, melodia;
    LocalDate data;

    @FXML
    void dodajGodzine(ActionEvent event) {
        godzina = (String) comboBoxGodzina.getValue();
        System.out.println(godzina);
        }
    @FXML
    void dodajMinute(ActionEvent event) {
        minuta = (String) comboBoxMinuta.getValue();
        System.out.println(minuta);
    }
    @FXML
    void dodajDate(ActionEvent event) {
        data = dataPicker.getValue();
        System.out.println(data);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<String> list1 = new ArrayList<String>();
        for (int i=1; i<=24; i++){
            list1.add(String.valueOf(i));
        }
        ObservableList obList = FXCollections.observableList(list1);
        comboBoxGodzina.getItems().clear();
        comboBoxGodzina.setItems(obList);

        List<String> list2 = new ArrayList<String>();
        for (int i=0; i<=59; i++){
            list2.add(String.valueOf(i));
        }

        ObservableList obList2 = FXCollections.observableList(list2);
        comboBoxMinuta.getItems().clear();
        comboBoxMinuta.setItems(obList2);





    }





}
