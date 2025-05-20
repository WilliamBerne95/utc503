package dao;

import modele.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompteDAO {
    private Connection connection;
    
    public CompteDAO() {
        this.connection = Connexion.getInstance().getConnection();
    }
    
    public Compte getById(int id) {
        Compte compte = null;
        String query = "SELECT * FROM comptes WHERE id = ?";
        
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                compte = new Compte();
                compte.setId(rs.getInt("id"));
                compte.setLogin(rs.getString("login"));
                compte.setPassword(rs.getString("password"));
                compte.setRole(rs.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return compte;
    }
    
    public Compte getByLogin(String login) {
        Compte compte = null;
        String query = "SELECT * FROM comptes WHERE login = ?";
        
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, login);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                compte = new Compte();
                compte.setId(rs.getInt("id"));
                compte.setLogin(rs.getString("login"));
                compte.setPassword(rs.getString("password"));
                compte.setRole(rs.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return compte;
    }
    
    public List<Compte> getAll() {
        List<Compte> comptes = new ArrayList<>();
        String query = "SELECT * FROM comptes";
        
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Compte compte = new Compte();
                compte.setId(rs.getInt("id"));
                compte.setLogin(rs.getString("login"));
                compte.setPassword(rs.getString("password"));
                compte.setRole(rs.getString("role"));
                comptes.add(compte);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return comptes;
    }
    
    public boolean add(Compte compte) {
        String query = "INSERT INTO comptes (login, password, role) VALUES (?, ?, ?)";
        
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, compte.getLogin());
            pstmt.setString(2, compte.getPassword());
            pstmt.setString(3, compte.getRole());
            
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean update(Compte compte) {
        String query = "UPDATE comptes SET login = ?, password = ?, role = ? WHERE id = ?";
        
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, compte.getLogin());
            pstmt.setString(2, compte.getPassword());
            pstmt.setString(3, compte.getRole());
            pstmt.setInt(4, compte.getId());
            
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean delete(int id) {
        String query = "DELETE FROM comptes WHERE id = ?";
        
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean authenticate(String login, String password) {
        String query = "SELECT * FROM comptes WHERE login = ? AND password = ?";
        
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, login);
            pstmt.setString(2, password);
            
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}