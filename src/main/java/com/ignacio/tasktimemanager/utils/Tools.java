package com.ignacio.tasktimemanager.utils;

import java.util.Scanner;

public class Tools {
    public static Scanner scanner = new Scanner(System.in);
    
    public static String normalize(String name) {
        if (name == null) return "";

        return name
                .toLowerCase()
                .trim()
                .replace(".exe", "")
                .replace(" ", "");
    }
}
