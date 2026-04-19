package com.ignacio.tasktimemanager.consoleUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ignacio.tasktimemanager.utils.Tools;

public class ConsoleUI {
    public static void showProcesses(Map<String,List<Integer>> processes){
        List<String> names = new ArrayList<>(processes.keySet());
        int option = 1;
        for (String name : names) {
            System.out.println(option+". " +name);
            option++;
        }
    }

    public static int chooseApp(int maxOptions) {

    System.out.println("¿Qué aplicación quieres cerrar?");

    int selection = Tools.scanner.nextInt();

    if (selection < 1 || selection > maxOptions) {
        System.out.println("Selección inválida");
        return -1;
    }

    return selection - 1;
    }
}
