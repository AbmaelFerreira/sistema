package br.com.sistema.domain;


import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "estado")
public class Estado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 40)
    @NotBlank(message = "Favor informara um nome")
    private String nome;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    private List<Empresa> empresa;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Empresa> getEmpresa() {
        return empresa;
    }

    public void setEmpresa(List<Empresa> empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                '}';
    }
}
