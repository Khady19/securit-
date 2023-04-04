package sn.isi.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.isi.dao.ComptesImpl;
import sn.isi.dao.RepositoryImpl;
import sn.isi.entities.Comptes;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(value = "/login" , name = "login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ComptesImpl cdao ;
    private RepositoryImpl reposit;
    public void init() {
        cdao = new ComptesImpl();

    }
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	String email = request.getParameter("email");
        String password = request.getParameter("password");

        //ComptesImpl cdao = new ComptesImpl();
//        int value = compteDAO.validate(username, password);
//        response.getWriter().println(value);
        if(cdao.validate(email, password) ){
        	
  
        	response.sendRedirect(request.getContextPath()+"/comptes/liste");
        }else{
            request.setAttribute("error", "Username ou Password  incorrect !!!");
            this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }

    }}
