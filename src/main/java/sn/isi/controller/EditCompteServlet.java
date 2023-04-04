package sn.isi.controller;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.isi.dao.ComptesImpl;
import sn.isi.entities.Comptes;

/**
 * Servlet implementation class EditCompteServlet
 */
public class EditCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ComptesImpl cdao ;
    public void init() {
        cdao = new ComptesImpl();

    } 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCompteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//réccupération de l'id du compte
		String id = request.getParameter("id");
		//à travers l'id on essaye de réccupérer le compte au niveau de la base de donnée
		Comptes compte = cdao.get(Integer.parseInt(id), new Comptes());
		request.setAttribute("compte", compte);
        this.getServletContext().getRequestDispatcher("/WEB-INF/formCompte.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//à travers l'id on essaye de réccupérer le compte au niveau de la base de donnée
		Comptes compte = cdao.get(Integer.parseInt(id), new Comptes());
		compte.setUsername(username);
		compte.setPassword(password);
		cdao.update(compte);
		response.sendRedirect(request.getContextPath()+"/home");
	}

}
