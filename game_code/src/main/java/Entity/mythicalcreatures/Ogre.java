package Entity.mythicalcreatures;

import Entity.Enums.CharacterClass;
import Entity.Enums.Weapon;
import Entity.Magic;
import Entity.Melee;
import behaviour.IMythicalCreature;

public class Ogre extends Melee implements IMythicalCreature {

    Magic owner;

    public Ogre(String name, Weapon rightHandWeapon, int healthPoints, CharacterClass characterClass, Weapon leftHandWeapon) {
        super(name, rightHandWeapon, healthPoints, characterClass, leftHandWeapon);
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
