package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class MostraEmpresa {
	
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("mostrando empresa");
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Banco banco = new Banco();
		
		Empresa emp = banco.getEmpresaById(id);
		System.out.println(emp.getId()+": " + emp.getNome());
		
		request.setAttribute("empresa", emp);
		RequestDispatcher rd = request.getRequestDispatcher("/formAlterarEmpresa.jsp");
		rd.forward(request, response);
	}
}
