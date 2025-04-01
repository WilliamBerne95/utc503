package rpg.decorator;

import rpg.core.Character;

public class Invisibility extends CharacterDecorator {

    public Invisibility(Character decoratedCharacter) {
        super(decoratedCharacter);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "\nCapacité spéciale: Invisibilité - Peut disparaître de la vue pendant une courte période.";
    }

    @Override
    public int getPowerLevel() {
        // L'invisibilité augmente le niveau de puissance de 10
        return super.getPowerLevel() + 10;
    }
}
