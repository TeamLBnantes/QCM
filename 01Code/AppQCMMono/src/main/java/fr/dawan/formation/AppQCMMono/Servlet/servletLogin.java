package fr.dawan.formation.AppQCMMono.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.formation.AppQCMMono.Services.UserService;
import sun.security.util.Password;

@WebServlet("/servletLogin")
public class servletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserService userService = new UserService();

	public servletLogin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String password = request.getParameter("password");
		String email = request.getParameter("email");

		if(userService.controlLogin(email, password)) {
			request.setAttribute("email", email);

			request.getRequestDispatcher("//AppQCMMono//WebContent//WEB-INF//view//welcome.jsp").forward(request, response);
			///AppQCMMono/WebContent/WEB-INF/view/welcome.jsp
		}else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}



	}
}
