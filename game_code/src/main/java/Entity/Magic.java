package Entity;

import Entity.Enums.CharacterClass;
import Entity.Enums.SpellType;
import Entity.Enums.Weapon;
import behaviour.IMythicalCreature;
import behaviour.SpellCast;

import java.util.ArrayList;

public class Magic extends Entity {

    public SpellCast spellCast;
    private IMythicalCreature pet;

    public Magic(String name, Weapon rightHandWeapon, int healthPoints, CharacterClass characterClass, ArrayList<SpellType> spells, IMythicalCreature pet) {
        super(name, rightHandWeapon, healthPoints, characterClass);
        spellCast = new SpellCast(controller, this, spells);
        this.pet = pet;
    }

    public IMythicalCreature getPet() {
        return this.pet;
    }

    public void setPet(IMythicalCreature pet) {
        this.pet = pet;
        pet.setAsPet(this);
    }

    public void removePet() {
        this.pet = null;
    }
}
