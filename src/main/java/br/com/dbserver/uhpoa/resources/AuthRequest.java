package br.com.dbserver.uhpoa.resources;

import lombok.Data;

@Data
public class AuthRequest {
    private String login;
    private String password;
}
