package com.task.Tasks.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;


@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Users")
public class Users implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @NotNull
    @Column(name = "Nome")
    private String nome;

    @NotNull
    @Column(name = "email",unique = true)
    private String email;

    @NotNull
    @Column(name = "Senha")
    private String password;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
//    private List<Tasks> tasks;
}
