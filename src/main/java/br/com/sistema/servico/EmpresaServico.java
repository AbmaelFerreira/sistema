package br.com.sistema.servico;

import br.com.sistema.domain.Empresa;
import br.com.sistema.domain.Estado;
import br.com.sistema.domain.Municipio;

import java.util.List;

public interface EmpresaServico {

    void salvar(Empresa paciente);
    void atualizar(Empresa paciente);
    void excluir (long id);
    Empresa recuperarPorId(long id);
    List<Empresa> recuperar();
    List<Estado> recuperarEstado();
    List<Municipio> recuperarMunicipio();
}
