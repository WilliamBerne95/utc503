package rpg.main;
import rpg.builder.CharacterBuilder;
import rpg.core.Character;
import rpg.core.Party;
import rpg.dao.CharacterDAO;
import rpg.decorator.FireResistance;
import rpg.decorator.Invisibility;
import rpg.decorator.Telepathy;
import rpg.settings.GameSettings;

/**
 * Classe principale démontrant le fonctionnement du système.
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("======== Générateur de Personnages pour Jeu de Rôle ========\n");
        
        // Configuration du jeu (Singleton)
        GameSettings settings = GameSettings.getInstance();
        settings.setMaxStatPoints(25); // Définit la limite maximale de points
        
        System.out.println("Configuration du jeu:");
        System.out.println("- Points de statistique maximum: " + settings.getMaxStatPoints() + "\n");
        
        // Création d'un DAO pour les personnages
        CharacterDAO characterDAO = new CharacterDAO();
        
        try {
            // Création de personnages avec le Builder
            System.out.println("Création de personnages...");
            
            // Personnage 1: Guerrier
            Character warrior = new CharacterBuilder()
                .setName("Grimgor")
                .setStrength(12)
                .setAgility(8)
                .setIntelligence(5)
                .build();
            
            // Personnage 2: Mage
            Character mage = new CharacterBuilder()
                .setName("Elenia")
                .setStrength(4)
                .setAgility(7)
                .setIntelligence(14)
                .build();
            
            // Personnage 3: Rôdeur
            Character ranger = new CharacterBuilder()
                .setName("Legoras")
                .setStrength(8)
                .setAgility(12)
                .setIntelligence(5)
                .build();
            
            // Personnage avec trop de points (va lancer une exception)
            try {
                Character invalidCharacter = new CharacterBuilder()
                    .setName("Tricheur")
                    .setStrength(15)
                    .setAgility(10)
                    .setIntelligence(10)
                    .build();
                System.out.println("Erreur: Ce personnage aurait dû être rejeté!");
            } catch (IllegalStateException e) {
                System.out.println("Personnage invalide détecté: " + e.getMessage());
            }
            
            // Ajout de capacités spéciales avec le Decorator
            System.out.println("\nAjout de capacités spéciales...");
            
            // Guerrier avec résistance au feu
            Character fireWarrior = new FireResistance(warrior);
            
            // Mage avec télépathie
            Character telepathicMage = new Telepathy(mage);
            
            // Rôdeur avec invisibilité et résistance au feu
            Character stealthyRanger = new Invisibility(new FireResistance(ranger));
            
            // Sauvegarde des personnages via le DAO
            System.out.println("\nSauvegarde des personnages...");
            characterDAO.save(fireWarrior);
            characterDAO.save(telepathicMage);
            characterDAO.save(stealthyRanger);
            
            // Création d'une équipe
            System.out.println("\nCréation d'une équipe...");
            Party adventurers = new Party("Les Aventuriers de l'Artefact Perdu");
            adventurers.addCharacter(fireWarrior);
            adventurers.addCharacter(telepathicMage);
            adventurers.addCharacter(stealthyRanger);
            
            // Affichage des personnages
            System.out.println("\n======== Descriptions des Personnages ========");
            for (Character character : characterDAO.findAll()) {
                System.out.println("\n" + character.getDescription());
                System.out.println("----------------------------------------");
            }
            
            // Affichage de l'équipe
            System.out.println("\n======== Description de l'Équipe ========");
            System.out.println(adventurers.getDescription());
            
            // Trier les personnages
            System.out.println("\n======== Équipe triée par puissance ========");
            adventurers.sortByPower();
            System.out.println(adventurers.getDescription());
            
            System.out.println("\n======== Équipe triée par nom ========");
            adventurers.sortByName();
            System.out.println(adventurers.getDescription());
            
            // Simulation d'un combat simple
            System.out.println("\n======== Simulation de Combat ========");
            simulateCombat(fireWarrior, stealthyRanger);
            
        } catch (Exception e) {
            System.err.println("Une erreur est survenue: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Simule un combat simple entre deux personnages.
     * Le personnage avec le niveau de puissance le plus élevé a plus de chances de gagner.
     */
    private static void simulateCombat(Character character1, Character character2) {
        System.out.println("Combat entre " + character1.getName() + " et " + character2.getName() + "!");
        System.out.println(character1.getName() + " - Puissance: " + character1.getPowerLevel());
        System.out.println(character2.getName() + " - Puissance: " + character2.getPowerLevel());
        
        // Calcul des probabilités basées sur les niveaux de puissance
        double totalPower = character1.getPowerLevel() + character2.getPowerLevel();
        double char1Chance = character1.getPowerLevel() / totalPower;
        
        // Génération d'un nombre aléatoire entre 0 et 1
        double random = Math.random();
        
        System.out.println("\nLe combat fait rage...");
        
        // Détermine le vainqueur
        if (random < char1Chance) {
            System.out.println(character1.getName() + " remporte la victoire!");
        } else {
            System.out.println(character2.getName() + " remporte la victoire!");
        }
    }
}
