package com.example.demo.logick.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("authorities")
public class Authority {
    @Id
    String username;
    String authority = "ROLE_USER";

    public Authority() {
    }

    public Authority(String username) {
        this.username = username;
        this.authority = "ROLE_USER";
    }

    @Override
    public String toString() {
        return "Authority{" +
                "username='" + username + '\'' +
                ", authority='" + authority + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

}
