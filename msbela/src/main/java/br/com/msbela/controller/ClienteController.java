package br.com.msbela.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.msbela.business.ClienteBusiness;
import br.com.msbela.entity.Cliente;

@ManagedBean
@RequestScoped
public class ClienteController implements AbstractController {
	@EJB
	private ClienteBusiness clienteBusiness;
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private Cliente cliente = new Cliente();

	@ManagedProperty(value = "#{param.id}")
	private String id;

	@PostConstruct
	public void load() {
		if (this.id != null && !this.id.isEmpty()) {
			this.cliente = clienteBusiness.find(id);
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String save() {
		clienteBusiness.save(this.cliente);
		return "cliente?faces-redirect=true";
	}

	@Override
	public String delete() {
		clienteBusiness.remove(this.cliente.getId());
		return "cliente?faces-redirect=true";
	}

	public List<Cliente> list() {
		return clientes = clienteBusiness.findAll();
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
