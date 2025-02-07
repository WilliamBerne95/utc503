public abstract class Personnage {
    private String nom;
    private String prenom;

    public Personnage() { }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " {" +
            "nom='" + nom + "', " +
            "prenom='" + prenom + "'}";
    }
}