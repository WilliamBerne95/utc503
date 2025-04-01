package rpg.decorator;

import rpg.core.Character;

/**
 * Décorateur qui ajoute la capacité de télépathie à un personnage.
 */
public class Telepathy extends CharacterDecorator {

    /**
     * Constructeur qui prend un personnage à décorer avec la télépathie.
     * @param decoratedCharacter Le personnage à décorer.
     */
    public Telepathy(Character decoratedCharacter) {
        super(decoratedCharacter);
    }

    /**
     * Surcharge de la méthode pour ajouter la description de la télépathie.
     */
    @Override
    public String getDescription() {
        return super.getDescription() + "\nCapacité spéciale: Télépathie - Peut lire les pensées et communiquer mentalement.";
    }

    /**
     * Surcharge de la méthode pour augmenter le niveau de puissance grâce à la télépathie.
     */
    @Override
    public int getPowerLevel() {
        // La télépathie augmente le niveau de puissance de 12
        return super.getPowerLevel() + 12;
    }
}
