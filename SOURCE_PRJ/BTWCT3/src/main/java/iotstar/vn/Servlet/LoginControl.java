package iotstar.vn.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iotstar.vn.Dao.IAccountDao;
import iotstar.vn.Dao.Impl.AccountDaoImpl;
import iotstar.vn.Entity.Account;

/**
 * Servlet implementation class LoginControl
 */
@WebServlet("/login")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=UTF-8");
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		AccountDaoImpl accDao = new AccountDaoImpl();
		
		Account a = accDao.login(username, password);
		if(a == null) {
			
			request.setAttribute("mess", "Wrong username or password");
			//request.setAttribute("mess", username+password);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
			
		}else {
			//request.getRequestDispatcher("Admin.jsp").forward(request, response);
			response.sendRedirect("manageraccount");
			
			
			
		}
		
	}

	
}
