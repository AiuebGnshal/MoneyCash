package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    private static String text = "This new text \nThis new text2\nThis new text3\nThis new text4\n";
    private static String fileName = "";

    public static void main(String[] args) throws FileNotFoundException {

        //Запись в файл
        FileWorker.write(fileName, text);

    }

        public static void main (String fileName, String text) {
            //Определяем файл
            File file = new File(fileName);

            try {
                //проверяем, что если файл не существует то создаем его
                if(!file.exists()) file.createNewFile();

                //PrintWriter обеспечит возможности записи в файл
                PrintWriter out = new PrintWriter(file.getAbsoluteFile());

                try {
                    //Записываем текст у файл
                    out.print(text);
                } finally {
                    //После чего мы должны закрыть файл
                    //Иначе файл не запишется
                    out.close();
                }
            } catch(IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
