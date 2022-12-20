package filter;
 // Phân quyền
import model.UserModel;
import utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Decentralization implements Filter {
    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        String url = req.getRequestURL().toString();
        if (url.contains("admin")) {
            checkAuthor(request, response, chain, "admin");
        } else if (url.contains("student")) {
            checkAuthor(request, response, chain, "student");
        } else if (url.contains("teacher")){
            checkAuthor(request, response, chain, "teacher");
        } else if (url.contains("head_of_department")) {
            checkAuthor(request, response, chain, "head_of_department");
        }
        else {
            chain.doFilter(request,response);
        }
    }

    protected void checkAuthor(ServletRequest request, ServletResponse response, FilterChain chain, String role) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        UserModel model = (UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL");
        if (model != null) {
            if (model.getRole().equals(role)) {
                chain.doFilter(request,response);
            } else {
                resp.sendRedirect(req.getContextPath() + "/login");
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }

    @Override
    public void destroy() {

    }
}

