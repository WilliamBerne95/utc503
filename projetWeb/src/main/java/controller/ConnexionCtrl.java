package controller;

import dao.CompteDAO;
import modele.Compte;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/connexion/*")
public class ConnexionCtrl extends HttpServlet {
    private CompteDAO compteDAO;
    
    @Override
    public void init() throws ServletException {
        super.init();
        compteDAO = new CompteDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getPathInfo();
        
        if (action == null) {
            action = "/login";
        }
        
        switch (action) {
            case "/login":
                showLoginForm(request, response);
                break;
            case "/logout":
                logout(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/");
                break;
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getPathInfo();
        
        if (action == null) {
            action = "/login";
        }
        
        switch (action) {
            case "/login":
                authenticate(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/");
                break;
        }
    }
    
    private void showLoginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/html/jsp/index.jsp").forward(request, response);
    }
    
    private void authenticate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        
        if (compteDAO.authenticate(login, password)) {
            Compte compte = compteDAO.getByLogin(login);
            HttpSession session = request.getSession();
            session.setAttribute("user", compte);
            response.sendRedirect(request.getContextPath() + "/WEB-INF/Vue/jsp/dashboard.jsp");
        } else {
            request.setAttribute("errorMessage", "Login ou mot de passe incorrect");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
    
    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect(request.getContextPath() + "/");
    }
}