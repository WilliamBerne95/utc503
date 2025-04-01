package rpg.builder;

import rpg.core.Character;
import rpg.settings.GameSettings;

/**
 * Implémentation du pattern Builder pour construire un personnage étape par étape.
 */
public class CharacterBuilder {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;

    public CharacterBuilder() {
        // Initialisation avec des valeurs par défaut
        this.name = "Inconnu";
        this.strength = 1;
        this.agility = 1;
        this.intelligence = 1;
    }

    /**
     * Définit le nom du personnage.
     * @param name Le nom du personnage.
     * @return Le builder pour chaînage.
     */
    public CharacterBuilder setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Définit la force du personnage.
     * @param strength La force du personnage.
     * @return Le builder pour chaînage.
     */
    public CharacterBuilder setStrength(int strength) {
        if (strength < 1) {
            throw new IllegalArgumentException("La force doit être supérieure à 0");
        }
        this.strength = strength;
        return this;
    }

    /**
     * Définit l'agilité du personnage.
     * @param agility L'agilité du personnage.
     * @return Le builder pour chaînage.
     */
    public CharacterBuilder setAgility(int agility) {
        if (agility < 1) {
            throw new IllegalArgumentException("L'agilité doit être supérieure à 0");
        }
        this.agility = agility;
        return this;
    }

    /**
     * Définit l'intelligence du personnage.
     * @param intelligence L'intelligence du personnage.
     * @return Le builder pour chaînage.
     */
    public CharacterBuilder setIntelligence(int intelligence) {
        if (intelligence < 1) {
            throw new IllegalArgumentException("L'intelligence doit être supérieure à 0");
        }
        this.intelligence = intelligence;
        return this;
    }

    /**
     * Construit et retourne un nouveau personnage avec les attributs définis.
     * @return Un nouveau personnage.
     * @throws IllegalStateException Si le personnage ne respecte pas les règles du jeu.
     */
    public Character build() {
        Character character = new Character(name, strength, agility, intelligence);
        
        // Vérification des règles du jeu
        GameSettings gameSettings = GameSettings.getInstance();
        if (!gameSettings.isValid(character)) {
            throw new IllegalStateException(
                "Le personnage dépasse la limite de points de statistique (" + 
                gameSettings.getMaxStatPoints() + ")");
        }
        
        return character;
    }
}
