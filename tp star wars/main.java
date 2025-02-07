public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Film 1 
        Film film1 = new Film();
        film1.setTitre("Star Wars: Un nouvel espoir");
        film1.setAnneeDesSortie(1977);
        film1.setNumeroEpisode(4);
        film1.setCout(11000000.0);
        film1.setRecette(775400000.0);

        // Film 2 
        Film film2 = new Film();
        System.out.println("Entrez le titre du film:");
        film2.setTitre(scanner.nextLine());
        System.out.println("Entrez l'année de sortie:");
        film2.setAnneeDesSortie(scanner.nextInt());
        System.out.println("Entrez le numéro d'épisode:");
        film2.setNumeroEpisode(scanner.nextInt());
        System.out.println("Entrez le coût du film:");
        film2.setCout(scanner.nextDouble());
        System.out.println("Entrez la recette du film:");
        film2.setRecette(scanner.nextDouble());

        System.out.println("\nFilms créés:");
        System.out.println(film1);
        System.out.println(film2);

        scanner.close();
    }
}