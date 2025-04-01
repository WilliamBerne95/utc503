package rpg.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Classe représentant une équipe de personnages.
 */
public class Party {
    private String name;
    private List<Character> members;
    
    /**
     * Constructeur qui initialise une équipe vide avec un nom.
     * @param name Le nom de l'équipe.
     */
    public Party(String name) {
        this.name = name;
        this.members = new ArrayList<>();
    }
    
    /**
     * Ajoute un personnage à l'équipe.
     * @param character Le personnage à ajouter.
     * @return true si le personnage a été ajouté, false s'il est déjà dans l'équipe.
     */
    public boolean addCharacter(Character character) {
        if (character == null) {
            return false;
        }
        
        // Vérifie si le personnage est déjà dans l'équipe
        for (Character member : members) {
            if (member.getName().equals(character.getName())) {
                return false;
            }
        }
        
        // Ajoute le personnage à l'équipe
        members.add(character);
        return true;
    }
    
    /**
     * Supprime un personnage de l'équipe par son nom.
     * @param characterName Le nom du personnage à supprimer.
     * @return true si le personnage a été supprimé, false s'il n'existe pas dans l'équipe.
     */
    public boolean removeCharacter(String characterName) {
        return members.removeIf(c -> c.getName().equals(characterName));
    }
    
    /**
     * Calcule la puissance totale de l'équipe (somme des niveaux de puissance).
     * @return La puissance totale de l'équipe.
     */
    public int getTotalPower() {
        int totalPower = 0;
        for (Character character : members) {
            totalPower += character.getPowerLevel();
        }
        return totalPower;
    }
    
    /**
     * Trie les personnages de l'équipe par niveau de puissance (du plus fort au plus faible).
     */
    public void sortByPower() {
        Collections.sort(members, new Comparator<Character>() {
            @Override
            public int compare(Character c1, Character c2) {
                return c2.getPowerLevel() - c1.getPowerLevel(); // Ordre décroissant
            }
        });
    }
    
    /**
     * Trie les personnages de l'équipe par nom (ordre alphabétique).
     */
    public void sortByName() {
        Collections.sort(members, new Comparator<Character>() {
            @Override
            public int compare(Character c1, Character c2) {
                return c1.getName().compareTo(c2.getName());
            }
        });
    }
    
    /**
     * Obtient le nombre de personnages dans l'équipe.
     * @return Le nombre de personnages.
     */
    public int size() {
        return members.size();
    }
    
    /**
     * Retourne une description détaillée de l'équipe.
     * @return La description de l'équipe et de ses membres.
     */
    public String getDescription() {
        StringBuilder description = new StringBuilder();
        description.append("Équipe: ").append(name).append("\n");
        description.append("Membres (").append(members.size()).append("):\n");
        
        for (int i = 0; i < members.size(); i++) {
            description.append("- ").append(members.get(i).getName())
                      .append(" (Puissance: ").append(members.get(i).getPowerLevel()).append(")\n");
        }
        
        description.append("Puissance totale: ").append(getTotalPower());
        return description.toString();
    }
    
    /**
     * Obtient la liste des membres de l'équipe.
     * @return La liste des personnages de l'équipe.
     */
    public List<Character> getMembers() {
        return new ArrayList<>(members); // Retourne une copie pour éviter la modification directe
    }
    
    /**
     * Obtient le nom de l'équipe.
     * @return Le nom de l'équipe.
     */
    public String getName() {
        return name;
    }
}
