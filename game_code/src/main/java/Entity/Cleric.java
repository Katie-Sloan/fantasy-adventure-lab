package Entity;

import Entity.Enums.CharacterClass;
import Entity.Enums.SpellType;
import Entity.Enums.Weapon;
import behaviour.SpellCast;

import java.util.ArrayList;

public class Cleric extends Entity {
    public SpellCast spellCast;
    ArrayList<SpellType> spells;


    public Cleric(String name, Weapon rightHandWeapon, int healthPoints, CharacterClass characterClass, ArrayList<SpellType> spells) {
        super(name, rightHandWeapon, healthPoints, characterClass);
        this.spellCast = new SpellCast(controller, this, spells);
    }
}
