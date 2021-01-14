package Player;

import Player.Enums.CharacterClass;
import Player.Enums.Weapon;

public abstract class Player {

    private String name;
    private Weapon rightHandWeapon;
    private int healthPoints;
    private int gems;
    private CharacterClass characterClass;

    public Player(String name, Weapon rightHandWeapon, int healthPoints, CharacterClass characterClass) {
        this.characterClass = characterClass;
        this.name = name;
        this.rightHandWeapon = rightHandWeapon;
        this.healthPoints = healthPoints;
        this.gems = 0;
    }
    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public String getName() {
        return this.name;
    }

    public Weapon getRightHandWeapon() {
        return this.rightHandWeapon;
    }

    public void setRightHandWeapon(Weapon newWeapon) {
        if (this.canEquipWeapon(newWeapon)) {
            this.rightHandWeapon = newWeapon;
        }
    }

    public int getHealthPoints() {
        return this.healthPoints;
    }

    public int getGems() {
        return this.gems;
    }

    public void addGems(int gems) {
        this.gems += gems;
    }

    public boolean move() { // implement later
        return true;
    }

    protected boolean canEquipWeapon(Weapon weapon) {
        return weapon.getClassNumber() == this.characterClass.getCharacterClass();
    }
}
