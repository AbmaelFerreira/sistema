package br.com.sistema.dao;

import br.com.sistema.domain.Empresa;
import br.com.sistema.domain.Estado;
import br.com.sistema.domain.Municipio;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EmpresaDaoImpl implements EmpresaDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void salvar(Empresa empresa) {
        em.persist(empresa);
    }

    @Override
    public void atualizar(Empresa empresa) {
        em.merge(empresa);
    }

    @Override
    public void excluir(long empresaId) {
        em.remove(em.getReference(Empresa.class, empresaId));
    }

    @Override
    public Empresa recuperarPorID(long id) {
        return em.find(Empresa.class,id);
    }

    @Override
    public List<Empresa> recuperar() {
        return em.createQuery("select  e from Empresa e", Empresa.class).getResultList();
    }

    @Override
    public List<Estado> recuperarEstado() {
        return em.createQuery("select a from Estado a", Estado.class).getResultList();
    }

    @Override
    public List<Municipio> recuperarMunicipio() {
        return em.createQuery("select m from Municipio m", Municipio.class).getResultList();
    }

}
