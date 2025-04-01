package rpg.dao;

import java.util.List;

/**
 * Interface générique pour le pattern DAO (Data Access Object).
 * @param <T> Le type d'objet à gérer.
 */
public interface DAO<T> {
    
    /**
     * Sauvegarde un élément.
     * @param item L'élément à sauvegarder.
     * @return true si l'opération a réussi, false sinon.
     */
    boolean save(T item);
    
    /**
     * Recherche un élément par son nom.
     * @param name Le nom de l'élément à rechercher.
     * @return L'élément trouvé ou null s'il n'existe pas.
     */
    T findByName(String name);
    
    /**
     * Récupère tous les éléments.
     * @return La liste de tous les éléments.
     */
    List<T> findAll();
}
