package sn.isi.controller;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.isi.dao.ComptesImpl;
import sn.isi.dao.IComptes;
import sn.isi.entities.Comptes;

/**
 * Servlet implementation class ListeCompteServlet
 */
@WebServlet(urlPatterns = "/Liste")
public class ListeCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeCompteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 IComptes cdao = new ComptesImpl();
	        Comptes c = new Comptes();
	        List<Comptes> comptes = cdao.list(c);

	        request.setAttribute("comptes", comptes);
	        request.getRequestDispatcher("/WEB-INF/comptes/liste.jsp").forward(request, response);
	    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
