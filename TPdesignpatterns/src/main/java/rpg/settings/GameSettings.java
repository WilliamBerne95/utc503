package rpg.settings;

import rpg.core.Character;

public class GameSettings {
    // Instance unique (pattern Singleton)
    private static GameSettings instance;
    
    // Valeur maximale que peut atteindre la somme des stats
    private int maxStatPoints;
    
    private GameSettings() {
        // Valeur par défaut
        this.maxStatPoints = 30;
    }
    
    public static synchronized GameSettings getInstance() {
        if (instance == null) {
            instance = new GameSettings();
        }
        return instance;
    }
    
    public boolean isValid(Character character) {
        // Vérifie si la somme des stats ne dépasse pas le maximum autorisé
        return character.getTotalStats() <= maxStatPoints;
    }
    
    public int getMaxStatPoints() {
        return maxStatPoints;
    }
    
    public void setMaxStatPoints(int maxStatPoints) {
        if (maxStatPoints < 3) {
            throw new IllegalArgumentException("La valeur maximale de points de statistique doit être d'au moins 3");
        }
        this.maxStatPoints = maxStatPoints;
    }
}
