package ru.stasim;


import ru.stasim.service.TextService;
import ru.stasim.service.WebService;

import javax.swing.*;
import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        TextService textService = new TextService();
        WebService webService = new WebService();
        String name = JOptionPane.showInputDialog("Дайте название файлу");
        String urlAddress="https://"+ JOptionPane.showInputDialog("Введите адрес страницы https://");
        String file =JOptionPane.showInputDialog("Назовите фаел для подсчета слов");
        webService.savePage(urlAddress, name);
        textService.words("result/" +file );



    }
}
