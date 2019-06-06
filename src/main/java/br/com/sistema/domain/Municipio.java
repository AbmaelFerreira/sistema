package br.com.sistema.domain;

import com.sun.javafx.beans.IDProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

//@Entity
//@Table(name="municipio")
public class Municipio  implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 40)
    @NotBlank(message = "Favor informar um minicipio")
    private String cidade;

    @OneToMany(mappedBy = "estado_id", cascade = CascadeType.ALL)
    private List<Estado> estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public List<Estado> getEstado() {
        return estado;
    }

    public void setEstado(List<Estado> estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Municipio)) return false;
        Municipio municipio = (Municipio) o;
        return getId() == municipio.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Municipio{" +
                "id=" + id +
                '}';
    }
}
