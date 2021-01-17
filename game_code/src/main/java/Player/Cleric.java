package Player;

import Player.Enums.CharacterClass;
import Player.Enums.SpellType;
import Player.Enums.Weapon;
import behaviour.SpellCast;

import java.util.ArrayList;

public class Cleric extends Player {
    public SpellCast spellCast;
    ArrayList<SpellType> spells;


    public Cleric(String name, Weapon rightHandWeapon, int healthPoints, CharacterClass characterClass, ArrayList<SpellType> spells) {
        super(name, rightHandWeapon, healthPoints, characterClass);
        this.spellCast = new SpellCast(controller, this, spells);
    }
}
