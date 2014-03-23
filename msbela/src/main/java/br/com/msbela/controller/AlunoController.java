package br.com.msbela.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.msbela.business.AlunoBusiness;
import br.com.msbela.entity.Aluno;

@ManagedBean
@RequestScoped
public class AlunoController {

	@EJB
	AlunoBusiness alunoBusiness;

	List<Aluno> alunos = new ArrayList<Aluno>();

	private Aluno aluno = new Aluno();

	@ManagedProperty(value = "#{param.id}")
	private String id;

	@PostConstruct
	public void load() {
		if (this.id != null && !this.id.isEmpty()) {
			this.aluno = alunoBusiness.find(id);
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String save() {
		alunoBusiness.save(this.aluno);
		return "aluno?faces-redirect=true";
	}

	public String remove() {
		alunoBusiness.remove(aluno.getId());
		return "aluno?faces-redirect=true";
	}

	public List<Aluno> list() {
		return alunos = alunoBusiness.findAll();
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

}
