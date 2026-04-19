package com.ignacio.tasktimemanager;
import java.util.List;
import java.util.Map;

import com.ignacio.tasktimemanager.service.ProcessService;

import oshi.software.os.OSProcess;



public class App {
    public static void main(String[] args) {
        ProcessService service = new ProcessService();
        Map<String,List<Integer>> apps = service.getProcesses();

        
        /*Mostrar todos */
        // for (String name : apps.keySet()) {
        //     System.out.println(name + " (" + apps.get(name).size() + " procesos)");
        // }
    }
}
