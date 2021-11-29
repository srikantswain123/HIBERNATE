package com.nt.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.ProductDto;
import com.nt.service.ProductService;
import com.nt.service.ProductServiceImpl;
@WebServlet("/controler")
public class MainControler extends HttpServlet {
	private ProductService service;
	
	public void init() throws ServletException {
		service=new ProductServiceImpl();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd=null;
		ProductDto dto=null;
		int id=0;
		id=Integer.parseInt(req.getParameter("pid"));
		try {
		dto=service.fetchData(id);
		req.setAttribute("Prod", dto);
		rd=req.getRequestDispatcher("/search.jsp");
		rd.forward(req, res);
		
		}catch(Exception e) {
			e.printStackTrace();
			rd=req.getRequestDispatcher("/error.jsp");
			rd.forward(req, res);
		}
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 doGet(req,res);
	}

}
