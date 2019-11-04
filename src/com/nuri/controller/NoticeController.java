package com.nuri.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.jrockit.jfr.RequestDelegate;

/**
 * Servlet implementation class NoticeController
 */
@WebServlet("/NoticeController")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Notice Controller");
		
		
		String url = request.getServletPath();
		url = url.substring(8, url.lastIndexOf("."));
		String path = "";
		boolean flag = false;
		
//		String [] ar = url.split("/");
//		url = ar[2].substring(0, ar[2].lastIndexOf("."));
		
		System.out.println(url);
		
//		url = request.getPathInfo();
//		String uri = request.getRequestURI();
//		StringBuffer url2 = request.getRequestURL();
		
		//System.out.println(request.getServletPath());	//	/notice/noticeList.notice
		//System.out.println(uri);						//	/Servlet_4_mvc2/notice/noticeList.notice
		//System.out.println(url2.toString());			//	http://localhost/Servlet_4_mvc2/notice/noticeList.notice
		
		if(url.equals("noticeList")) {
			path = "./noticeList.jsp";
			request.setAttribute("board", "noticeList");
			flag = true;
		}else if(url.equals("noticeSelect")) {
			String check = request.getParameter("check");
			
			//check가 1이면 select, 아니라면 list
//			if(check.equals("1")) {
//				path = "./noticeSelect.jsp";
//				request.setAttribute("select", "noticeSelect");
//				flag=true;
//			}else {
//				path = "./noticeList.notice";
//			}
		}
		
		
		if(flag) {
			RequestDispatcher view = request.getRequestDispatcher(path);
			view.forward(request, response);
		}else {
			response.sendRedirect(path);
		}
		
//		
//		if(command.equals("list")) {
//			path="./noticeList.jsp";
//			request.setAttribute("board", "notice");
//		}else {
//			path="./noticeSelect.jsp";
//		}
//		
//		
//		RequestDispatcher view = request.getRequestDispatcher(path);
//		view.forward(request, response);
		
//		response.sendRedirect("./noticeList.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
