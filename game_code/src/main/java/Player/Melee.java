package Player;

import Player.Enums.CharacterClass;
import Player.Enums.Weapon;
import behaviour.IHit;

public class Melee extends Player implements IHit {

    private Weapon leftHandWeapon;

    public Melee(String name, Weapon rightHandWeapon, int healthPoints, CharacterClass characterClass, Weapon leftHandWeapon) {
        super(name, rightHandWeapon, healthPoints, characterClass);
        this.leftHandWeapon = leftHandWeapon;
    }

    public Weapon getLeftHandWeapon() {
        return leftHandWeapon;
    }

    public void setLeftHandWeapon(Weapon newWeapon) {
        if (this.canEquipWeapon(newWeapon)) {
            this.leftHandWeapon = newWeapon;
        }
    }

    public void hit() {} // Delete me soon

//    public void hit(MythicalCreature opponent) {
//        opponent.takeDamage(getAttackPoints());
//    }
//
    public int getAttackPoints() {
        return this.leftHandWeapon.getDamage() + this.getRightHandWeapon().getDamage();
    }
}
