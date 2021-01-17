package Player;

import Player.Enums.CharacterClass;
import Player.Enums.HealItem;
import Player.Enums.Weapon;
import behaviour.Heal;
import behaviour.Hit;

public abstract class Player {
    protected PlayerController controller;
    private Hit hit;
    private String name;
    private Weapon rightHandWeapon;
    private int healthPoints;
    private final int MAX_HEALTH_POINTS;
    private int gems;
    private final CharacterClass CHARACTER_CLASS;
    public Heal heal;

    public Player(String name, Weapon rightHandWeapon, int healthPoints, CharacterClass characterClass) {
        this.CHARACTER_CLASS = characterClass;
        this.name = name;
        this.rightHandWeapon = rightHandWeapon;
        this.healthPoints = MAX_HEALTH_POINTS = healthPoints;
        this.gems = 0;
        controller = new PlayerController();
        hit = new Hit(controller);
        this.heal = new Heal(controller, this);
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

    public void heal(HealItem healItem) {
        if (doesExceedMAX_HEALTH_POINTS(healItem.getHealPoints())) {
            this.healthPoints = MAX_HEALTH_POINTS;
        } else {
            this.healthPoints += healItem.getHealPoints();
        }
    }

    private boolean doesExceedMAX_HEALTH_POINTS(int healPoints) {
        return this.healthPoints + healPoints >= MAX_HEALTH_POINTS;
    }
    protected boolean canEquipWeapon(Weapon weapon) {
        return weapon.getClassNumber() == this.CHARACTER_CLASS.getCharacterClass();
    }
    protected int getAttackPoints() {
        return this.getRightHandWeapon().getDamage();
    }


}
