package Player;

import Player.Enums.CharacterClass;
import Player.Enums.Weapon;
import behaviour.Hit;
import behaviour.Move;

public class Melee extends Player {

    private Hit hit;
    private Move move;
    private Weapon leftHandWeapon;
    private Player target;
    public Melee(String name, Weapon rightHandWeapon, int healthPoints, CharacterClass characterClass, Weapon leftHandWeapon) {
        super(name, rightHandWeapon, healthPoints, characterClass);
        this.leftHandWeapon = leftHandWeapon;
        hit = new Hit(controller);
        move = new Move(controller);
    }
                                    //########## START Getters and Setters ##########//
    public Player getTarget() { return target; }
    public void setTarget(Player target) { this.target = target; }
    public Weapon getLeftHandWeapon() {
        return leftHandWeapon;
    }

    public void setLeftHandWeapon(Weapon newWeapon) {
        if (this.canEquipWeapon(newWeapon)) {
            this.leftHandWeapon = newWeapon;
        }
    }
                                    //########## END Getters and Setters ##########//





    // POO DONT WANT TO SEE IT
    @Override
    protected int getAttackPoints() {
        return this.leftHandWeapon.getPower() + this.getRightHandWeapon().getPower();
    }
}
