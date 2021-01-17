package Entity.mythicalcreatures;

import Entity.Enums.CharacterClass;
import Entity.Enums.SpellType;
import Entity.Enums.Weapon;
import Entity.Magic;
import behaviour.IMythicalCreature;

import java.util.ArrayList;

public class Dragon extends Magic implements IMythicalCreature {

    Magic owner;

    public Dragon(String name, Weapon rightHandWeapon, int healthPoints, CharacterClass characterClass, ArrayList<SpellType> spells, IMythicalCreature pet, Magic owner) {
        super(name, rightHandWeapon, healthPoints, characterClass, spells, pet);
        this.owner = owner;
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
