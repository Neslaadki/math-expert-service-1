package com.example.mathexpertservice1.impl.util;

import lombok.SneakyThrows;

import java.io.File;
import java.util.Scanner;

public class FileReader {

    @SneakyThrows
    public static String read(String path){
        var scanner = new Scanner(new File(path));
        StringBuilder text = new StringBuilder();
        while (scanner.hasNext()){
            text.append(scanner.nextLine());
        }
        return text.toString();
    }
}
