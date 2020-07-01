package ru.stasim.service;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.awt.List;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@Data
public class TextService {
    private HashMap<String, Integer> wordToCount = new HashMap<>();



    public HashMap<String, Integer> words(String pAp) {
        Path path = Paths.get(pAp);
        String[] words;
        try {
            Charset charset = StandardCharsets.UTF_8;
            String lf = new String(Files.readAllBytes(path), charset);
            Document document = Jsoup.parse(lf, "UTF-8");
            Elements text = document.getElementsByTag("body");
            lf = text.text();
            lf = lf.replace(")", " ");
            lf = lf.replace("(", " ");
            lf = lf.replace(",", " ");
            lf = lf.replace(".", " ");
            lf = lf.replace("'", " ");
            lf = lf.replace("{", " ");
            lf = lf.replace("}", " ");
            lf = lf.replace(":", " ");
            lf = lf.replace(";", " ");
            lf = lf.replace('"', ' ');
            lf = lf.replace('\n', ' ');
            lf = lf.replace('\r', ' ');
            lf = lf.replace('\t', ' ');
            lf = lf.replace('[', ' ');
            lf = lf.replace(']', ' ');
            lf = lf.replace('_', ' ');
            lf = lf.replace('&', ' ');
            lf = lf.replace('=', ' ');
            lf = lf.replace('<', ' ');
            lf = lf.replace('>', ' ');
            lf = lf.replace('!', ' ');
            lf = lf.replace('?', ' ');
            lf = lf.replace('/', ' ');// Заменяем пробелами знаки
            lf = lf.toUpperCase();// Изменяем регистр строки на верхний
            Scanner in = new Scanner(lf);
            String string = in.nextLine();
            words = string.split("\\s+");// Разделяем текст на пробелы
            for (String word : words) {
                if (!wordToCount.containsKey(word)) {
                    wordToCount.put(word, 0);
                }
                wordToCount.put(word, wordToCount.get(word) + 1);
            }
            for (String word : wordToCount.keySet()) {
                if (StringUtils.isNoneBlank(word))
                    System.out.println(word + " " + wordToCount.get(word));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage() + " " + " Такой фаел отсутствует");
        }
        return null;
    }


}