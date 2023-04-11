package com.base.entities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FolderUtil {
    public static void main(String[] args) throws IOException {
        File file = new File("dosya.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fileWriter = new FileWriter(file, false);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        bWriter.write("asdfasdf");
        bWriter.close();
    }
    private static void createFileAndWrite(String str) throws IOException {
        File file = new File("dosya.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fileWriter = new FileWriter(file, false);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        bWriter.write("asdfasdf");
        bWriter.close();
    }
}
