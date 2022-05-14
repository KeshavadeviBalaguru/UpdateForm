package com.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		int id=Integer.parseInt(request.getParameter("sid"));
		int sa=Integer.parseInt(request.getParameter("sage"));
		try
		{
			Connection conn=DbConnect.getConnection();
			Statement st=conn.createStatement();
			
			String sel="select * from student where sid="+id;
			ResultSet rs=st.executeQuery(sel);
			if(rs.next())
			{
				String upd="update student set sage="+sa+" where sid="+id;
				int i=st.executeUpdate(upd);
				if(i>0)
				{
					out.println("Record Updated successfully");
				}
				else
				{
					out.println("Record Not Updates");
				}
			}
			else
			{
				out.println("Record Not exists");
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}

}
