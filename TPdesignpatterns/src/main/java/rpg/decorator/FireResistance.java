package rpg.decorator;

import rpg.core.Character;

public class FireResistance extends CharacterDecorator {

    public FireResistance(Character decoratedCharacter) {
        super(decoratedCharacter);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "\nCapacité spéciale: Résistance au feu - Immunisé contre les dégâts de type feu.";
    }

    @Override
    public int getPowerLevel() {
        // La résistance au feu augmente le niveau de puissance de 8
        return super.getPowerLevel() + 8;
    }
}
