package com.goit.pshcherba.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Util {
    public static String readSql(String filePath) {
        String input = null;
        try {
            input = new String(Files.readAllBytes(Path.of(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }
}
