package rpg.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rpg.core.Character;

public class CharacterDAO implements DAO<Character> {
    
    // Map qui stocke les personnages en mémoire (simulant une base de données)
    private Map<String, Character> charactersDb = new HashMap<>();
   
    @Override
    public boolean save(Character character) {
        if (character == null) {
            return false;
        }
        
        // Vérifie si un personnage avec ce nom existe déjà
        if (charactersDb.containsKey(character.getName())) {
            // Dans un vrai DAO, on pourrait mettre à jour le personnage existant
            // Pour simplifier, nous considérons que c'est une erreur
            return false;
        }
        
        // Sauvegarde le personnage
        charactersDb.put(character.getName(), character);
        return true;
    }
 
    @Override
    public Character findByName(String name) {
        return charactersDb.get(name);
    }
    
    @Override
    public List<Character> findAll() {
        return new ArrayList<>(charactersDb.values());
    }

    public boolean deleteByName(String name) {
        if (charactersDb.containsKey(name)) {
            charactersDb.remove(name);
            return true;
        }
        return false;
    }
    
    public void clear() {
        charactersDb.clear();
    }
}