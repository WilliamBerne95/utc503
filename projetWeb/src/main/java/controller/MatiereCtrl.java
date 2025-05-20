package controller;

import dao.MatiereDAO;
import modele.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/matiere/*")
public class MatiereCtrl extends HttpServlet {
    private MatiereDAO matiereDAO;
    
    @Override
    public void init() throws ServletException {
        super.init();
        matiereDAO = new MatiereDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Vérification de l'authentification
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/connexion/login");
            return;
        }
        
        String action = request.getPathInfo();
        
        if (action == null) {
            action = "/list";
        }
        
        switch (action) {
            case "/list":
                listMatieres(request, response);
                break;
            case "/add":
                showAddForm(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/delete":
                deleteMatiere(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/matiere/list");
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
        
        String action = request.getPathInfo();
        
        if (action == null) {
            action = "/list";
        }
        
        switch (action) {
            case "/add":
                addMatiere(request, response);
                break;
            case "/edit":
                updateMatiere(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/matiere/list");
                break;
        }
    }
    
    private void listMatieres(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Matiere> matieres = matiereDAO.getAll();
        request.setAttribute("matieres", matieres);
        request.getRequestDispatcher("/WEB-INF/Vue/jsp/matiere/list.jsp").forward(request, response);
    }
    
    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/Vue/jsp/matiere/add.jsp").forward(request, response);
    }
    
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Matiere matiere = matiereDAO.getById(id);
        
        if (matiere != null) {
            request.setAttribute("matiere", matiere);
            request.getRequestDispatcher("/WEB-INF/Vue/jsp/matiere/edit.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/matiere/list");
        }
    }
    
    private void addMatiere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        int nbHeures = Integer.parseInt(request.getParameter("nbHeures"));
        
        Matiere matiere = new Matiere();
        matiere.setNom(nom);
        matiere.setNbHeures(nbHeures);
        
        matiereDAO.add(matiere);
        response.sendRedirect(request.getContextPath() + "/matiere/list");
    }
    
    private void updateMatiere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        int nbHeures = Integer.parseInt(request.getParameter("nbHeures"));
        
        Matiere matiere = new Matiere();
        matiere.setId(id);
        matiere.setNom(nom);
        matiere.setNbHeures(nbHeures);
        
        matiereDAO.update(matiere);
        response.sendRedirect(request.getContextPath() + "/matiere/list");
    }
    
    private void deleteMatiere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        matiereDAO.delete(id);
        response.sendRedirect(request.getContextPath() + "/matiere/list");
    }
}