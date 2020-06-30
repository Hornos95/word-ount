package ru.stasim;


import ru.stasim.service.TextService;
import ru.stasim.service.WebService;

import javax.swing.*;
import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        String name = JOptionPane.showInputDialog("Название файла");
        String urlAddress="https://"+ JOptionPane.showInputDialog("Введите адрес страницы https://");
        TextService textSerice = new TextService();
        WebService webService = new WebService();
        webService.savePage(urlAddress, name);
        textSerice.words("result/" +name );



    }
}
