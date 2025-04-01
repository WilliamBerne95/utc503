package rpg.decorator;

import rpg.core.Character;

public abstract class CharacterDecorator extends Character {
    protected Character decoratedCharacter;

    public CharacterDecorator(Character decoratedCharacter) {
        // Appel du constructeur de la classe mère avec les attributs du personnage décoré
        super(decoratedCharacter.getName(), 
              decoratedCharacter.getStrength(), 
              decoratedCharacter.getAgility(), 
              decoratedCharacter.getIntelligence());
        
        this.decoratedCharacter = decoratedCharacter;
    }

    @Override
    public String getDescription() {
        return decoratedCharacter.getDescription();
    }

    @Override
    public int getPowerLevel() {
        return decoratedCharacter.getPowerLevel();
    }

    // Délégation des getters au personnage décoré
    @Override
    public String getName() {
        return decoratedCharacter.getName();
    }

    @Override
    public int getStrength() {
        return decoratedCharacter.getStrength();
    }

    @Override
    public int getAgility() {
        return decoratedCharacter.getAgility();
    }

    @Override
    public int getIntelligence() {
        return decoratedCharacter.getIntelligence();
    }

    @Override
    public int getTotalStats() {
        return decoratedCharacter.getTotalStats();
    }
}
