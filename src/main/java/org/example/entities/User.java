package org.example.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Random;

//@EqualsAndHashCode
@Data
@Accessors(chain = true)
public class User {
    private int id;
    private String name;
    private String email;
    private String gender;
    private String status;
}
