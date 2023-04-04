package sn.isi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.isi.dao.ComptesImpl;
import sn.isi.dao.RepositoryImpl;
import sn.isi.dto.ComptesDto;
import sn.isi.dto.DroitsDto;
import sn.isi.entities.Comptes;
import sn.isi.service.ComptesDtoImpl;
import sn.isi.service.DroitsDtoImpl;
import sn.isi.service.IComptesDto;
import sn.isi.service.IDroitsDto;



/**
 * Servlet implementation class ComptesServlet
 */
@WebServlet(urlPatterns = "/Comptes", name = "comptes")
public class ComptesServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Comptes c = new Comptes();
	        //ComptesImpl dao = new ComptesImpl();
	        RepositoryImpl<Comptes> cdao = new RepositoryImpl<Comptes>();
	        List<Comptes> listecompte = cdao.selectAll();
	        System.out.println("+++++++++++++++++++++++++ " + listecompte.size());
	        request.setAttribute("listecompte", listecompte);
	        
	       //request.setAttribute("droits", list);
	        //request.getRequestDispatcher("WEB-INF/comptes/add.jsp").forward(request, response);
	        request.getRequestDispatcher("WEB-INF/comptes/liste.jsp").forward(request, response);

	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IComptesDto cdto = new ComptesDtoImpl();
        ComptesDto c = new ComptesDto();
        c.setUsername(request.getParameter("username"));
        c.setPassword(request.getParameter("password"));
        List<DroitsDto> droitsList = new ArrayList<>();
        IDroitsDto ddto = new DroitsDtoImpl();
        DroitsDto d = new DroitsDto();
        List<DroitsDto> droits = ddto.list();
        String result  = request.getParameter("droits");
        for (DroitsDto newd: droits) {
            if (newd.getId() == Integer.parseInt(result)){
                droits.add(newd);
                break;
	            }
	}
        c.setDroits(droitsList);

        if (cdto.add(c)==1){
            request.setAttribute("success", "Compte ajoutÃ© avec succes!");
            request.getRequestDispatcher("WEB-INF/comptes/add.jsp").forward(request, response);
            doGet(request, response);
        }
	}}
	
    

    
	


