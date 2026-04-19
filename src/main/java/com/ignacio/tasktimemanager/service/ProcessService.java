package com.ignacio.tasktimemanager.service;

import com.ignacio.tasktimemanager.config.AppConfig;
import com.ignacio.tasktimemanager.utils.Tools;

import oshi.SystemInfo;
import oshi.software.os.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessService {
    
    public Map<String,List<Integer>> getProcesses() {
        SystemInfo si = new SystemInfo();
        OperatingSystem os = si.getOperatingSystem();
        Map<String,List<Integer>> appsMap = new HashMap<>();

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

}
