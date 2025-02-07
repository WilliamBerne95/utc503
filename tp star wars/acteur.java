public class Acteur {
    private String nom;
    private String prenom;
    private Personnage personnage; 

    public Acteur() { }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " {" +
            "nom='" + nom + "', " +
            "prenom='" + prenom + "'}";
    }
}