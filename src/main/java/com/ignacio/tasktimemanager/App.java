package com.ignacio.tasktimemanager;
import java.util.List;
import com.ignacio.tasktimemanager.service.ProcessService;
import oshi.software.os.OSProcess;

public class App {
    public static void main(String[] args) {
        ProcessService service = new ProcessService();
        List<OSProcess> lista = service.getProcesses();

        for (OSProcess osProcess : lista) {
            System.out.println(osProcess.getName());
        }
    }
}
