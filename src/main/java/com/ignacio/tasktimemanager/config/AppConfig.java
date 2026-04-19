package com.ignacio.tasktimemanager.config;

import java.util.List;

public class AppConfig {

    public static final List<String> WHITELIST = List.of(
        "steam","discord","steam","whatsapp","factorio",
        "chrome","opera","firefox","msedge","vivaldi"
    );

    public static final List<String> BLACKLIST = List.of(
        "system","idle","svchost","wininit","csrss"
    );
}

