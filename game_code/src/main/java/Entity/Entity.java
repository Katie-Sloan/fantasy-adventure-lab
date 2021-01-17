package Entity;

import Entity.Enums.CharacterClass;
import Entity.Enums.Weapon;
import behaviour.Heal;
import behaviour.Hit;
import behaviour.IMythicalCreature;
import behaviour.Move;

public abstract class Entity {
    protected PlayerController controller;
    private Hit hit;
    private String name;
    private Weapon rightHandWeapon;
    protected int healthPoints;
    private final int MAX_HEALTH_POINTS;
    private int gems;
    private final CharacterClass CHARACTER_CLASS;
    public Heal heal;
    private Move move;

    public Entity(String name, Weapon rightHandWeapon, int healthPoints, CharacterClass characterClass) {
        this.CHARACTER_CLASS = characterClass;
        this.name = name;
        this.rightHandWeapon = rightHandWeapon;
        this.healthPoints = MAX_HEALTH_POINTS = healthPoints;
        this.gems = 0;
        controller = new PlayerController();
        hit = new Hit(controller);
        heal = new Heal(controller, this);
        move = new Move(controller);
    }
                        //########## START Getters and Setters ##########//
    public String getName() { return this.name; }
    public Weapon getRightHandWeapon() { return this.rightHandWeapon; }
    public int getHealthPoints() { return this.healthPoints; }
    public int getGems() { return this.gems; }
    public CharacterClass getCHARACTER_CLASS() { return CHARACTER_CLASS; }

    public void addGems(int gems) {
        this.gems += gems;
    }

    public void setRightHandWeapon(Weapon newWeapon) {
        if (!this.canEquipWeapon(newWeapon)) return;
        this.rightHandWeapon = newWeapon;
    }
                        //########## END Getters and Setters ##########//

    public void startHitting(Entity target) {
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

    public void heal(int healPoints) {
        if (doesExceedMAX_HEALTH_POINTS(healPoints)) {
            this.healthPoints = MAX_HEALTH_POINTS;
        } else {
            this.healthPoints += healPoints;
        }
    }

    private boolean doesExceedMAX_HEALTH_POINTS(int healPoints) {
        return this.healthPoints + healPoints >= MAX_HEALTH_POINTS;
    }
    protected boolean canEquipWeapon(Weapon weapon) {
        return weapon.getClassNumber() == this.CHARACTER_CLASS.getCharacterClass();
    }
    protected int getAttackPoints() {
        return this.getRightHandWeapon().getPower();
    }


}
