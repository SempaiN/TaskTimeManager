package com.ignacio.tasktimemanager;
import java.util.List;
import java.util.Map;


import com.ignacio.tasktimemanager.service.ProcessService;
import com.ignacio.tasktimemanager.consoleUI.*;
import com.ignacio.tasktimemanager.utils.Tools;



public class App {
    public static void main(String[] args) {

        ProcessService service = new ProcessService();
        Map<String,List<Integer>> apps = service.getProcesses();
        ConsoleUI.showProcesses(apps);
        List<String> appsNames = service.getAppNames();

        int num = Tools.scanner.nextInt();
        System.out.println(appsNames.get(num));

        
    }
}
