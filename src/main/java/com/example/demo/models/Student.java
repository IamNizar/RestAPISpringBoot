package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@NoArgsConstructor
@Entity
public class Student implements Serializable {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private int id;
    @Column(nullable = false,length = 25)
   private String firstname;
    @Column(nullable = false,length = 25)
   private String lastname;
    @Column(nullable = false,unique = true,length = 30)
   private String email;

    public Student(@JsonProperty("id") int id, @JsonProperty("firstname") String firstname
    ,@JsonProperty("lastname") String lastname,@JsonProperty("email") String email) {
        this.id=id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email=email;
    }



}
