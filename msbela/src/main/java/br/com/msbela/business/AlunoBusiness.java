package br.com.msbela.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



import br.com.msbela.entity.Aluno;

@Stateless
public class AlunoBusiness extends AbstractBean<Aluno>{
	
    @PersistenceContext
    private EntityManager em;

	public AlunoBusiness() {
	   super(Aluno.class);
	}

	@SuppressWarnings("unchecked")
	public List<Aluno> findAll() {
	        return em.createQuery("select a from Aluno a order by a.natricula, a.nome asc")
	                 .getResultList();
	} 
	
	@Override
	protected EntityManager getEntityManager() {
	        return em;
	}
	 
	 
	 
	
}
