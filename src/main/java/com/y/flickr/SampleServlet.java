package com.y.flickr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class SampleServlet extends HttpServlet {
	

		         
			        private static final long serialVersionUID = -6154475799000019575L;
			         
			        private static final String greeting = "Photo ID:4549383";
			 
			        protected void doGet(HttpServletRequest request,
			                HttpServletResponse response) throws ServletException,
			                IOException {
			             
			            response.setContentType("text/html");
			            response.setStatus(HttpServletResponse.SC_OK);
			            response.getWriter().println(greeting);
			        }
			         
			    
			 
			}
