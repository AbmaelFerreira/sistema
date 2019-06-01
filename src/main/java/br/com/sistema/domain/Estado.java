package br.com.sistema.domain;

import org.hibernate.validator.constraints.NotBlank;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class Estado {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    @NotBlank(message = "Favor informara um nome")
    private String nome;

}
