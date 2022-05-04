package com.example.demo.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User {
    int id;
    private String user_name;
    private String password;
    private String phone;
    private int is_deleted;
}
