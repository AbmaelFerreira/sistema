package br.com.sistema.domain;


import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private  Long id;

    @Column(nullable = false, length = 40)
    @NotBlank(message = "Favor informar o nome da empresa")
    @Size(min = 5, max = 40, message = "O nome deve ser entre 5 e 50 caracteres")
    private String nome;

    @Column(nullable = false, length = 40)
    //@NotBlank(message = "Favor informar o nome da empresa")
    @Size(min = 5, max = 40, message = "A fantasia dever ser entre 5 e 30 caracteres")
    private String fantasia;

    @Column(name = "pessoa")
    @Enumerated(EnumType.STRING)
    private Pessoa pessoa;

    @Column
    private String fone;

    @Column
    private String rua;

    @Column
    private String numero;

    @Column
    private String complemento;

    @Column
    private String cep;

    @Column
    private String bairro;



  @ManyToOne //Leitura Muitos Empresas para 1 estado
  @JoinColumn(name = "estado")
  private Estado estado;

   @ManyToOne //Leitura Muitos Empresas para 1 municipio
   @JoinColumn(name = "municipio")
   private Municipio municipio;

    @Column
    private String cnpj;

    @Column(name ="ie")
    private String inscricaoEstadual;

    @Column(name = "tipo_IE")
    private String tipoIscricao;

    //@DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "data_cadastro")
    @NotNull(message = "Informe a data do agendamento")
    private Calendar dataCadastro;

    //@DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "data_atualiza")
    @NotNull(message = "Informe a data do agendamento")
    private Calendar dataAtualizacao;

    @Column(name="situacao")
    private int ativo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getTipoIscricao() {
        return tipoIscricao;
    }

    public void setTipoIscricao(String tipoIscricao) {
        this.tipoIscricao = tipoIscricao;
    }

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Calendar getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Calendar dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }


    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                '}';
    }
}
