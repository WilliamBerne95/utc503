public class Film {
    private String titre;
    private int anneeDesSortie;
    private int numeroEpisode;
    private double cout;
    private double recette;
    private ArrayList<Acteur> acteurs;

    public Film() { }
    
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " {" +
            "titre='" + titre + "', " +
            "anneeDesSortie=" + anneeDesSortie + ", " +
            "numeroEpisode=" + numeroEpisode + ", " +
            "cout=" + cout + ", " +
            "recette=" + recette + "}";
    }
}