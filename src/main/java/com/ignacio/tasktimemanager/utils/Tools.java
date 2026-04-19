package com.ignacio.tasktimemanager.utils;

public class Tools {
    public static String normalize(String name) {
        if (name == null) return "";

        return name
                .toLowerCase()
                .trim()
                .replace(".exe", "")
                .replace(" ", "");
    }
}
