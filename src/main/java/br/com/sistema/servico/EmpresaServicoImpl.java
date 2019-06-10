package br.com.sistema.servico;

import br.com.sistema.dao.EmpresaDao;
import br.com.sistema.domain.Empresa;
import br.com.sistema.domain.Estado;
import br.com.sistema.domain.Municipio;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmpresaServicoImpl implements  EmpresaServico {

    @Autowired
    private EmpresaDao empresaDao;

    @Override
    public void salvar(Empresa empresa) {
        empresaDao.salvar(empresa);
    }

    @Override
    public void atualizar(Empresa empresa) {
        empresaDao.atualizar(empresa);
    }

    @Override
    public void excluir(long id) {
        empresaDao.excluir(id);
    }

    @Override
    public Empresa recuperarPorId(long id) {
        return empresaDao.recuperarPorID(id);
    }

    @Transactional(readOnly = true)
    public List<Empresa> recuperar() {
        return empresaDao.recuperar();
    }

    @Override
    public List<Estado> recuperarEstado() {
        return empresaDao.recuperarEstado();
    }

    @Override
    public List<Municipio> recuperarMunicipio() {
        return empresaDao.recuperarMunicipio();
    }
}
