package com.ignacio.tasktimemanager;
import oshi.SystemInfo;
import oshi.software.os.*;


import java.util.List;

public class App {
    public static void main(String[] args) {
       SystemInfo si = new SystemInfo();
       OperatingSystem os = si.getOperatingSystem();

        List<OSProcess> processes = os.getProcesses();
        /*Conseguir procesos (y mostrarlos)*/
//        for (OSProcess p : processes) {
//            System.out.println(
//                    p.getProcessID() + " - " + p.getName()
//            );
//        }
        
        List<String> appsDentroLista = List.of(
                "vivaldi.exe",
                "discord.exe",
                "spotify.exe",
                "steam.exe"
        );
        List<String> appsSistema = List.of(
                "svchost"
        );



        for (OSProcess p : processes) {

            String name = p.getName().toLowerCase();

            if (appsSistema.contains(name) ||(p.getProcessID() > 1000 && p.getUpTime() > 10000)  )  {

                System.out.println(p.getProcessID() + " - " + p.getName());
            }
        }
    }
}
