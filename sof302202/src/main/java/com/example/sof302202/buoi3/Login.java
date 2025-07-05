package com.example.sof302202.buoi3;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Login {
    private String username;
    private String password;
    private Boolean remember;
}
