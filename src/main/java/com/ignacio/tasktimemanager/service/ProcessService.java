package com.ignacio.tasktimemanager.service;

import oshi.SystemInfo;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;

import java.util.*;

import com.ignacio.tasktimemanager.config.AppConfig;
import com.ignacio.tasktimemanager.utils.Tools;

public class ProcessService {

    private Map<String, List<Integer>> appsMap;

    public ProcessService() {
        this.appsMap = new HashMap<>();
    }

    
    public Map<String, List<Integer>> getProcesses() {

        SystemInfo si = new SystemInfo();
        OperatingSystem os = si.getOperatingSystem();

        appsMap.clear(); // importante para refrescar datos

        for (OSProcess process : os.getProcesses()) {

            String name = Tools.normalize(process.getName());
            int pid = process.getProcessID();

            if (AppConfig.BLACKLIST.contains(name)) {
                continue;
            }

            if (AppConfig.WHITELIST.contains(name)) {
                appsMap.computeIfAbsent(name, k -> new ArrayList<>())
                        .add(pid);
            }
        }

        return appsMap;
    }

    
    public List<String> getAppNames() {
        return new ArrayList<>(appsMap.keySet());
    }

    
    public void killApp(String name) {

        name = Tools.normalize(name);

        List<Integer> pids = appsMap.get(name);

        if (pids == null || pids.isEmpty()) {
            System.out.println("No hay procesos activos para: " + name);
            return;
        }

        System.out.println("Cerrando " + name );
        

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Interrumpido");
            return;
        }

        for (Integer pid : pids) {
            try {
                new ProcessBuilder(
                        "taskkill",
                        "/PID",
                        String.valueOf(pid),
                        "/F"
                ).start();
            } catch (Exception e) {
                System.out.println("Error cerrando PID: " + pid);
            }
        }

        System.out.println(name + " cerrado correctamente.");
    }
}