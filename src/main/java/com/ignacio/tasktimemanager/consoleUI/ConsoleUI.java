package com.ignacio.tasktimemanager.consoleUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ignacio.tasktimemanager.utils.Tools;

public class ConsoleUI {
    public static List<String> showProcesses(Map<String,List<Integer>> processes){
        List<String> names = new ArrayList<>(processes.keySet());

        for (int i = 0; i < names.size(); i++) {
            System.out.println((i + 1) + ". " + names.get(i));
        }

        return names;
    }

    public static List<Integer> chooseMultipleApps(int maxOptions) {

    System.out.println("Selecciona aplicaciones (ej: 1,3,5):");

    List<Integer> selected = new ArrayList<>();

    while (true) {
        try {
            String input = Tools.scanner.nextLine();

            String[] parts = input.split(",");

            for (String part : parts) {
                int num = Integer.parseInt(part.trim());

                if (num < 1 || num > maxOptions) {
                    System.out.println("Número fuera de rango: " + num);
                    selected.clear();
                    break;
                }

                selected.add(num - 1); 
            }

            if (!selected.isEmpty()) break;

        } catch (Exception e) {
            System.out.println("Entrada inválida. Usa formato: 1,3,5");
            selected.clear();
        }
    }

    return selected;
    }

    public static int selectTime() {

    System.out.println("¿En cuánto tiempo quieres cerrar tu aplicación? (minutos)");

    int time;

    while (true) {
        try {
            time = Tools.scanner.nextInt();

            if (time <= 0) {
                System.out.println("Introduce un número mayor que 0");
                continue;
            }

            break;

        } catch (Exception e) {
            System.out.println("Entrada inválida. Introduce un número:");
            Tools.scanner.nextLine(); 
        }
    }

    return time;
    }

    public static boolean confirmAction(List<String> apps) {

    System.out.println("\nVas a cerrar las siguientes aplicaciones:");

    for (String app : apps) {
        System.out.println("- " + app);
    }

    System.out.println("\n¿Estás seguro? (S/N)");

    String input = Tools.scanner.nextLine().trim().toLowerCase();

    return input.equals("s") || input.equals("si");
    }
}
