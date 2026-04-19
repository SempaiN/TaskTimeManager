package com.ignacio.tasktimemanager.config;

import java.util.List;

public class AppConfig {

    public static final List<String> WHITELIST = List.of(
        "steam.exe","discord.exe","steam.exe","whatsapp.exe","factorio.exe",
        "chrome.exe","opera.exe","firefox.exe","msedge.exe"
    );

    public static final List<String> BLACKLIST = List.of(
        "system","idle","svchost.exe","wininit.exe","csrss.exe"
    );
}

