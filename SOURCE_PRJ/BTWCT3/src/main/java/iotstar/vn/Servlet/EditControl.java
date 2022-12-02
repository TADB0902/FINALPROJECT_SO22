package iotstar.vn.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iotstar.vn.Dao.Impl.AccountDaoImpl;
import iotstar.vn.Entity.Account;

/**
 * Servlet implementation class EditControl
 */
@WebServlet("/editaccount")
public class EditControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		AccountDaoImpl accDao = new AccountDaoImpl();
		Account acc = accDao.get(Integer.parseInt(id));
		request.setAttribute("account", acc);
		request.getRequestDispatcher("Edit.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String id = request.getParameter("id");
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		String author = request.getParameter("author");
		AccountDaoImpl accDao = new AccountDaoImpl();
		Account a = new Account();
		a.setId(Integer.parseInt(id));
		a.setUser(username);
		a.setPass(password);
		a.setAuthor(author);
		accDao.edit(a);
		response.sendRedirect("manageraccount");
	}

}
