package com.noobs.codecoach.domain.entity;

public enum Role {
    COACH ("Coach"),
    COACHEE ("Coachee"),
    ADMINISTRATOR ("Administrator");

   private final String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public static Role fromValue(String value) {
        return switch (value) {
            case "Coach" -> COACH;
            case "Coachee" -> COACHEE;
            case "Administrator" -> ADMINISTRATOR;
            default -> throw new RuntimeException("Unknown role value: " + value);
        };
    }
}
