package com.noobs.codecoach.domain.entity;

public enum Role {
    COACH ("Coach"),
    COACHEE ("Coachee"),
    ADMINISTRATOR ("Administrator");

   private String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
