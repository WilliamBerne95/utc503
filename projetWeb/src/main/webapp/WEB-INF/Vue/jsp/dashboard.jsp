<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="modele.Compte" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tableau de bord - Gestion Académique</title>
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
    %>
    
    <div class="container">
        <header>
            <h1>Tableau de bord</h1>
            <div class="user-info">
                Connecté en tant que : <%= user.getLogin() %> (<%= user.getRole() %>)
                <a href="${pageContext.request.contextPath}/connexion/logout">Déconnexion</a>
            </div>
        </header>
        
        <div class="dashboard-menu">
            <div class="menu-item">
                <h2>Gestion des matières</h2>
                <p>Ajouter, modifier ou supprimer des matières.</p>
                <a href="${pageContext.request.contextPath}/matiere/list" class="btn">Accéder</a>
            </div>
            
            <% if("admin".equals(user.getRole())) { %>
            <div class="menu-item">
                <h2>Gestion des comptes</h2>
                <p>Ajouter, modifier ou supprimer des comptes utilisateurs.</p>
                <a href="${pageContext.request.contextPath}/compte/list" class="btn">Accéder</a>
            </div>
            <% } %>
        </div>
    </div>
</body>
</html>