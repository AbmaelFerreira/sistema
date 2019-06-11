package br.com.sistema.domain;

public enum Pessoa {
    JURIDICA("Juridica"), FISICA("Fisica");

    private String desc;

    //Metodo construtor
    Pessoa(String desc) {
        this.desc = desc;
    }

    //Metodo get

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
