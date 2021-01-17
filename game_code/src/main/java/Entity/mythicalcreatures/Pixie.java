package Entity.mythicalcreatures;

import Entity.Cleric;
import Entity.Enums.CharacterClass;
import Entity.Enums.SpellType;
import Entity.Enums.Weapon;
import Entity.Magic;
import behaviour.IMythicalCreature;

import java.util.ArrayList;

public class Pixie extends Cleric implements IMythicalCreature {

    Magic owner;

    public Pixie(String name, Weapon rightHandWeapon, int healthPoints, CharacterClass characterClass, ArrayList<SpellType> spells) {
        super(name, rightHandWeapon, healthPoints, characterClass, spells);
    }

    public void setAsPet(Magic magic) {
        this.owner = magic;
    }

    @Override
    public void takeDamage(int attackPoints) {
        if (this.healthPoints - attackPoints > 0) {
            this.healthPoints -= attackPoints;
        } else {
            this.healthPoints = 0;
            this.owner.removePet();
        }
    }
}
