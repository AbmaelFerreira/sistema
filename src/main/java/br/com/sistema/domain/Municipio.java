package br.com.sistema.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

public class Municipio {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 40)
    @NotBlank(message = "Favor informar um minicipio")
    private String cidade;

    @ManyToOne //Leitura Muitos Empresas para 1 estado
    @JoinColumn(name = "estado")
    private Estado estado;
}
