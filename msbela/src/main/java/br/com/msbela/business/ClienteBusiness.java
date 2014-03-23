package br.com.msbela.business;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.msbela.entity.Cliente;

public class ClienteBusiness extends AbstractBean<Cliente> {
	@PersistenceContext
	private EntityManager em;

	public ClienteBusiness() {
		super(Cliente.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> findAll() {
		return em.createQuery("select c from Cliente c order by c.nome asc")
				.getResultList();
	}

}
