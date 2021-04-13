package com.cibertec.ejercicio_3.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Posts {

    private int userId;
    private int id;
    private String title;
    private String body;

}
