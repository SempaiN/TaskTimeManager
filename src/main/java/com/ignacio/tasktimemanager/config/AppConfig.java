package com.ignacio.tasktimemanager.config;


import java.util.Set;

public class AppConfig {

    public static final Set<String> WHITELIST = Set.of(
            "steam",
            "discord",
            "whatsapp",
            "factorio",
            "chrome",
            "opera",
            "firefox",
            "msedge",
            "vivaldi",
            "code",
            "spotify",
            "notion",
            "codex",
            "epicgameslauncher"
    );

    public static final Set<String> BLACKLIST = Set.of(
            "system",
            "idle",
            "svchost",
            "wininit",
            "csrss"
    );
}

