package com.ignacio.tasktimemanager.service;

import oshi.SystemInfo;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;

import java.util.*;

import com.ignacio.tasktimemanager.config.AppConfig;
import com.ignacio.tasktimemanager.utils.Tools;

public class ProcessService {
    
    public Map<String, List<Integer>> getProcesses() {

    SystemInfo si = new SystemInfo();
    OperatingSystem os = si.getOperatingSystem();

    Map<String, List<Integer>> appsMap = new HashMap<>();

    for (OSProcess process : os.getProcesses()) {

        String name = Tools.normalize(process.getName());
        int pid = process.getProcessID();

        if (AppConfig.BLACKLIST.contains(name)) continue;

        if (AppConfig.WHITELIST.contains(name)) {
            appsMap
                .computeIfAbsent(name, k -> new ArrayList<>())
                .add(pid);
        }
    }

    return appsMap;
    }

    
    

    
    public void killApps(List<String> names, Map<String, List<Integer>> processes) {

    for (String name : names) {

        String normalized = Tools.normalize(name);

        List<Integer> pids = processes.get(normalized);

        if (pids == null || pids.isEmpty()) {
            System.out.println("No hay procesos activos para: " + name);
            continue;
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
}