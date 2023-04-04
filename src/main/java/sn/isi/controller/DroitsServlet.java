package sn.isi.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.isi.dto.DroitsDto;
import sn.isi.service.DroitsDtoImpl;
import sn.isi.service.IDroitsDto;

/**
 * Servlet implementation class DroitsServlet
 */
@WebServlet(urlPatterns = "/Droit")
public class DroitsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DroitsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        request.getRequestDispatcher("WEB-INF/droit/add.jsp").forward(request, response);

		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		IDroitsDto rdto = new DroitsDtoImpl();
        DroitsDto r = new DroitsDto();
        r.setName(request.getParameter("name"));
        if (rdto.add(r)==1) {
            request.setAttribute("success", "Droits ajoutÃ© avec succes!");
            //request.getRequestDispatcher("vue/droit/list.jsp").forward(request, response);
            doGet(request, response);
        }
	}

}
