package br.com.sistema.dao;

import br.com.sistema.domain.Empresa;
import br.com.sistema.domain.Estado;
import br.com.sistema.domain.Municipio;

import java.util.List;

public interface EmpresaDao {
    void salvar(Empresa empresa);
    void atualizar(Empresa empresa);
    void excluir(long empresaId);

    Empresa recuperarPorID(long id);
    List<Empresa> recuperar();
    List<Estado> recuperarEstado();
    List<Municipio> recuperarMunicipio();
}
