package dao;

import modele.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatiereDAO {
    private Connection connection;
    
    public MatiereDAO() {
        this.connection = Connexion.getInstance().getConnection();
    }
    
    public Matiere getById(int id) {
        Matiere matiere = null;
        String query = "SELECT * FROM matieres WHERE id = ?";
        
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                matiere = new Matiere();
                matiere.setId(rs.getInt("id"));
                matiere.setNom(rs.getString("nom"));
                matiere.setNbHeures(rs.getInt("nb_heures"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return matiere;
    }
    
    public List<Matiere> getAll() {
        List<Matiere> matieres = new ArrayList<>();
        String query = "SELECT * FROM matieres";
        
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Matiere matiere = new Matiere();
                matiere.setId(rs.getInt("id"));
                matiere.setNom(rs.getString("nom"));
                matiere.setNbHeures(rs.getInt("nb_heures"));
                matieres.add(matiere);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return matieres;
    }
    
    public boolean add(Matiere matiere) {
        String query = "INSERT INTO matieres (nom, nb_heures) VALUES (?, ?)";
        
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, matiere.getNom());
            pstmt.setInt(2, matiere.getNbHeures());
            
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean update(Matiere matiere) {
        String query = "UPDATE matieres SET nom = ?, nb_heures = ? WHERE id = ?";
        
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, matiere.getNom());
            pstmt.setInt(2, matiere.getNbHeures());
            pstmt.setInt(3, matiere.getId());
            
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean delete(int id) {
        String query = "DELETE FROM matieres WHERE id = ?";
        
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}