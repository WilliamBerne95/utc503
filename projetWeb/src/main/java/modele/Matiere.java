package modele;

import java.io.Serializable;

public class Matiere implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String nom;
    private int nbHeures;
    
    // Constructeur par défaut requis pour JavaBean
    public Matiere() {
    }
    
    public Matiere(int id, String nom, int nbHeures) {
        this.id = id;
        this.nom = nom;
        this.nbHeures = nbHeures;
    }
    
    // Getters et Setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public int getNbHeures() {
        return nbHeures;
    }
    
    public void setNbHeures(int nbHeures) {
        this.nbHeures = nbHeures;
    }
}