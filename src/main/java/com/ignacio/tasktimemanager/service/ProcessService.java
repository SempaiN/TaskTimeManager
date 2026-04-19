package com.ignacio.tasktimemanager.service;

import com.ignacio.tasktimemanager.config.AppConfig;
import oshi.SystemInfo;
import oshi.software.os.*;
import java.util.ArrayList;
import java.util.List;

public class ProcessService {
    public List<OSProcess> getProcesses() {
        SystemInfo si = new SystemInfo();
        OperatingSystem os = si.getOperatingSystem();
        List<OSProcess> result = new ArrayList<>();

        for (OSProcess process : os.getProcesses()) {
            String name = process.getName().toLowerCase();

            if (AppConfig.BLACKLIST.contains(name)) {
                continue;
            }

            if (AppConfig.WHITELIST.contains(name)) {
                result.add(process);
            }
        }

        return result;
    }
}
