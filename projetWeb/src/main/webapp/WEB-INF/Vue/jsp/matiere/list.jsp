<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="modele.Matiere, modele.Compte, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des matières - Gestion Académique</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <% 
        // Vérifier si l'utilisateur est connecté
        Compte user = (Compte) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/connexion/login");
            return;
        }
        
        // Récupérer la liste des matières
        List<Matiere> matieres = (List<Matiere>) request.getAttribute("matieres");
    %>
    
    <div class="container">
        <header>
            <h1>Liste des matières</h1>
            <div class="user-info">
                Connecté en tant que : <%= user.getLogin() %> (<%= user.getRole() %>)
                <a href="${pageContext.request.contextPath}/connexion/logout">Déconnexion</a>
            </div>
            <nav>
                <a href="${pageContext.request.contextPath}/WEB-INF/Vue/jsp/dashboard.jsp">Tableau de bord</a> |
                <a href="${pageContext.request.contextPath}/matiere/list">Matières</a>
                <% if("admin".equals(user.getRole())) { %>
                 | <a href="${pageContext.request.contextPath}/compte/list">Comptes</a>
                <% } %>
            </nav>
        </header>
        
        <div class="actions">
            <a href="${pageContext.request.contextPath}/matiere/add" class="btn">Ajouter une matière</a>
        </div>
        
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nom</th>
                    <th>Nombre d'heures</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <% if(matieres != null && !matieres.isEmpty()) { %>
                    <% for(Matiere matiere : matieres) { %>
                        <tr>
                            <td><%= matiere.getId() %></td>
                            <td><%= matiere.getNom() %></td>
                            <td><%= matiere.getNbHeures() %></td>
                            <td>
                                <a href="${pageContext.request.contextPath}/matiere/edit?id=<%= matiere.getId() %>" class="btn small">Modifier</a>
                                <a href="${pageContext.request.contextPath}/matiere/delete?id=<%= matiere.getId() %>" class="btn small delete" onclick="return confirm('Êtes-vous sûr de vouloir supprimer cette matière ?')">Supprimer</a>
                            </td>
                        </tr>
                    <% } %>
                <% } else { %>
                    <tr>
                        <td colspan="4">Aucune matière trouvée.</td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>