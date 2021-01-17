package Player;

import Player.Enums.CharacterClass;
import Player.Enums.SpellType;
import Player.Enums.Weapon;
import behaviour.SpellCast;

import java.util.ArrayList;

public class Magic extends Player{

    public SpellCast spellCast;

//    private MythicalCreature pet;

    public Magic(String name, Weapon rightHandWeapon, int healthPoints, CharacterClass characterClass, ArrayList<SpellType> spells) {
        super(name, rightHandWeapon, healthPoints, characterClass);
        spellCast = new SpellCast(controller, this, spells);
    }
}
