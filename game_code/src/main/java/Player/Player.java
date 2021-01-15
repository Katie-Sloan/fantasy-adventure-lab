package Player;

import Player.Enums.CharacterClass;
import Player.Enums.Weapon;
import behaviour.Hit;
import behaviour.IAction;

public abstract class Player {
    protected PlayerController controller;
    private Hit hit;
    private String name;
    private Weapon rightHandWeapon;
    private int healthPoints;
    private int gems;
    private final CharacterClass characterClass;

    public Player(String name, Weapon rightHandWeapon, int healthPoints, CharacterClass characterClass) {
        this.characterClass = characterClass;
        this.name = name;
        this.rightHandWeapon = rightHandWeapon;
        this.healthPoints = healthPoints;
        this.gems = 0;
        controller = new PlayerController();
        hit = new Hit(controller);
    }
                        //########## START Getters and Setters ##########//
    public String getName() { return this.name; }
    public Weapon getRightHandWeapon() { return this.rightHandWeapon; }
    public int getHealthPoints() { return this.healthPoints; }
    public int getGems() { return this.gems; }
    public CharacterClass getCharacterClass() { return characterClass; }

    public void addGems(int gems) {
        this.gems += gems;
    }

    public void setRightHandWeapon(Weapon newWeapon) {
        if (!this.canEquipWeapon(newWeapon)) return;
        this.rightHandWeapon = newWeapon;
    }
                        //########## END Getters and Setters ##########//

    public void startHitting(Player target) {
        if(getAttackPoints() == 0) return;
        hit.startHitting(getAttackPoints(), target);
    }

    public void stopCurrentAction() {
        controller.stopCurrentAction();
    }

    public void takeDamage(int attackPoints) {
        if (this.healthPoints - attackPoints > 0) {
            this.healthPoints -= attackPoints;
        } else {
            this.healthPoints = 0;
        }
    }

    protected boolean canEquipWeapon(Weapon weapon) {
        return weapon.getClassNumber() == this.characterClass.getCharacterClass();
    }
    protected int getAttackPoints() {
        return this.getRightHandWeapon().getDamage();
    }
}
