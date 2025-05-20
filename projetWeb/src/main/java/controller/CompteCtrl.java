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
import java.util.List;

@WebServlet("/compte/*")
public class CompteCtrl extends HttpServlet {
    private CompteDAO compteDAO;
    
    @Override
    public void init() throws ServletException {
        super.init();
        compteDAO = new CompteDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Vérification de l'authentification
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/connexion/login");
            return;
        }
        
        // Vérifier que l'utilisateur a le rôle 'admin'
        Compte user = (Compte) session.getAttribute("user");
        if (!"admin".equals(user.getRole())) {
            response.sendRedirect(request.getContextPath() + "/WEB-INF/Vue/jsp/dashboard.jsp");
            return;
        }
        
        String action = request.getPathInfo();
        
        if (action == null) {
            action = "/list";
        }
        
        switch (action) {
            case "/list":
                listComptes(request, response);
                break;
            case "/add":
                showAddForm(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/delete":
                deleteCompte(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/compte/list");
                break;
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Vérification de l'authentification
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/connexion/login");
            return;
        }
        
        // Vérifier que l'utilisateur a le rôle 'admin'
        Compte user = (Compte) session.getAttribute("user");
        if (!"admin".equals(user.getRole())) {
            response.sendRedirect(request.getContextPath() + "/WEB-INF/Vue/jsp/dashboard.jsp");
            return;
        }
        
        String action = request.getPathInfo();
        
        if (action == null) {
            action = "/list";
        }
        
        switch (action) {
            case "/add":
                addCompte(request, response);
                break;
            case "/edit":
                updateCompte(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/compte/list");
                break;
        }
    }
    
    private void listComptes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Compte> comptes = compteDAO.getAll();
        request.setAttribute("comptes", comptes);
        request.getRequestDispatcher("/WEB-INF/Vue/jsp/compte/list.jsp").forward(request, response);
    }
    
    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/Vue/jsp/compte/add.jsp").forward(request, response);
    }
    
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Compte compte = compteDAO.getById(id);
        
        if (compte != null) {
            request.setAttribute("compte", compte);
            request.getRequestDispatcher("/WEB-INF/Vue/jsp/compte/edit.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/compte/list");
        }
    }
    
    private void addCompte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        
        Compte compte = new Compte();
        compte.setLogin(login);
        compte.setPassword(password);
        compte.setRole(role);
        
        compteDAO.add(compte);
        response.sendRedirect(request.getContextPath() + "/compte/list");
    }
    
    private void updateCompte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        
        Compte compte = new Compte();
        compte.setId(id);
        compte.setLogin(login);
        compte.setPassword(password);
        compte.setRole(role);
        
        compteDAO.update(compte);
        response.sendRedirect(request.getContextPath() + "/compte/list");
    }
    
    private void deleteCompte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        compteDAO.delete(id);
        response.sendRedirect(request.getContextPath() + "/compte/list");
    }
}