package com.ignacio.tasktimemanager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import com.ignacio.tasktimemanager.service.ProcessService;
import com.ignacio.tasktimemanager.consoleUI.*;
import com.ignacio.tasktimemanager.utils.*;



public class App {
    public static void main(String[] args) {

        boolean running = true;

        while (running) {

            System.out.println("\n--- MENU ---");
            System.out.println("Pulsa ENTER para continuar o escribe 'exit' para salir");

            String input = Tools.scanner.nextLine().trim().toLowerCase();

            if (input.equals("exit")) {
                running = false;
                continue;
            }

            try {
                ProcessService service = new ProcessService();

                Map<String, List<Integer>> apps = service.getProcesses();

                List<String> names = ConsoleUI.showProcesses(apps);

                List<Integer> selectedIndexes =
                        ConsoleUI.chooseMultipleApps(names.size());

                List<String> selectedApps = new ArrayList<>();

                for (int i : selectedIndexes) {
                    selectedApps.add(names.get(i));
                }

                boolean confirmed = ConsoleUI.confirmAction(selectedApps);

                if (!confirmed) {
                    System.out.println("Operación cancelada.");
                    continue;
                }

                int time = ConsoleUI.selectTime() * 60 * 1000;

                System.out.println("Cerrando en " + ((time/60)/1000 ) + " minutos...");
                Thread.sleep(time);

                service.killApps(selectedApps, apps);

            } catch (InterruptedException e) {
                System.out.println("Ejecución interrumpida");
                Thread.currentThread().interrupt();
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }

        System.out.println("Saliendo del programa...");
    }
}
