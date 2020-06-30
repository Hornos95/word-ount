package ru.stasim.service;



import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WebService {
    public static void  savePage  (String urlAddress, String name)  {


        try {
            String pAp = "result/" + name ;
            URL url = new URL(urlAddress);
            try {
                InputStream input = url.openStream();

                try {
                    Path path = Path.of(pAp);
                    if (Files.exists(path)) {
                        Files.delete(path);
                    }
                    Files.copy(input, path);

                }catch (NullPointerException e){
                    e.printStackTrace();
                }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage()+" "+ "Вы забыли указать сайт");
        }

        }
        catch (IOException e){
            System.out.println(e.getMessage()+ " "+"не верно введен адресс страницы");
        }

    }
}

