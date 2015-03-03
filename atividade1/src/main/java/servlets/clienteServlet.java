package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Cliente;

@WebServlet(urlPatterns = "/clienteServlet")
public class clienteServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {		
		Cliente c = new Cliente();
		c.setId(Integer.parseInt(req.getParameter("id")));
		c.setNome(req.getParameter("nome"));
		c.setSexo(req.getParameter("sexo"));
		c.setEmail(req.getParameter("email"));
		c.setRg(req.getParameter("rg"));
		c.setCpf(req.getParameter("cpf"));
		
		req.setAttribute("c", c.getNome());
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("ClienteView.jsp");
		dispatcher.forward(req, resp);
	}

}
