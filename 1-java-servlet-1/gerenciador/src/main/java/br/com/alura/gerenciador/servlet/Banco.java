package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	static {
		Empresa empresa = new Empresa();
		empresa.setNome("Alura");
		empresa.setId(chaveSequencial++);
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Caelum");
		empresa2.setId(chaveSequencial++);
		lista.add(empresa);
		lista.add(empresa2);
	}
	

	public void adiciona(Empresa empresa) {
		Banco.lista.add(empresa);
		empresa.setId(Banco.chaveSequencial++);
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.lista;
	}

	public void removeEmpresaById(Integer id) {
		
		Iterator<Empresa> it =  lista.iterator();
		
		while (it.hasNext()) {
			Empresa emp = it.next();
			if(emp.getId()== id) {
				it.remove();
			}
		}
		
	}

	public Empresa getEmpresaById(Integer id) {
		for (Empresa empresa : lista) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}return null;
		
	}

}