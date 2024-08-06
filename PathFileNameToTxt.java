/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

/**
 *
 * @author daniele.zotta
 */


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class PathFileNameToTxt {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il percorso della directory:");
        String directoryPath = scanner.nextLine();
        String textFilePath = "fileNames.txt";

        try {
            // Leggi i nomi dei file dalla directory e scrivili in un file di testo
            writeToTextFile(directoryPath, textFilePath);
            System.out.println("Nomi dei file salvati con successo in: " + textFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
    
    
    private static void writeToTextFile(String directoryPath, String textFilePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(textFilePath))) {
            Files.list(Paths.get(directoryPath))
                    .filter(Files::isRegularFile)
                    .forEach(path -> {
                        try {
                            writer.write(path.getFileName().toString());
                            writer.newLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }
}
