package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.Connect;
import dao.LoginDao;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		
		String n=request.getParameter("username");  
		String p=request.getParameter("userpass"); 
		
//		out.print(n);
//		out.print();
		
		HttpSession session = request.getSession(false);
		if(session!=null)
			session.setAttribute("name", n);
		
		if(LoginDao.validate(n, p)){  
			Connect db = Connect.getDbCon();
			ResultSet rs;
			try {
				rs = db.query("select u.id, u.username, u.apellidos, u.nombres, u.correo, "
						+ "r.nombre_rol from usuarios u, roles r, roles_usuarios ru "
						+ "where u.id = ru.usuario_id and ru.rol_id = r.id "
						+ "and username like ('"+n+"')");
				ArrayList<dao.Usuario> al = new ArrayList<dao.Usuario>();
				while (rs.next())
				{
					 //Retrieve by column name
					dao.Usuario mUser = new dao.Usuario();
					
					mUser.setId(rs.getInt("id"));
					mUser.setCui(rs.getString("username"));
					mUser.setApellidos(rs.getString("apellidos"));
					mUser.setNombres(rs.getString("nombres"));
					mUser.setCorreo(rs.getString("correo"));
					mUser.setNombre_rol(rs.getString("nombre_rol"));
					
					al.add(mUser);
					
				}
			request.setAttribute("miPerfilList", al);
			if(whois(n).equals("Alumno")) 
				{
				RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
				rd.forward(request,response);
				}
			if(whois(n).equals("Admin")){
				RequestDispatcher rd=request.getRequestDispatcher("welcome-superadmin.jsp");
				rd.forward(request,response);
			}
			 
			}catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else{  
			out.print("<p style=\"color:red\">Sorry username or password error</p>");  
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
			rd.include(request,response);  
		}  

		out.close(); 
	
		
		
	}

	private String whois(String n) {
		// TODO Auto-generated method stub
		Connect db = Connect.getDbCon();
		ResultSet rs;
		String rol = null;
		try {
			rs = db.query("select r.nombre_rol from usuarios u, roles r, roles_usuarios ru "
					+ "where u.id = ru.usuario_id and ru.rol_id = r.id "
					+ "and username like ('"+n+"')");
			
			ArrayList<dao.Usuario> al = new ArrayList<dao.Usuario>();
			while (rs.next())
			{
				rol = rs.getString("nombre_rol"); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return rol;
	}

	private boolean isAlumno(String n) {
		// TODO Auto-generated method stub
		return false;
	}

}
