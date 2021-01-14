package Player.Enums;

import Player.Player;

public enum Weapon {

    AXE(1, 3),
    BIG_AXE(1, 6),
    CRAP_AXE(1, 2),
    STAFF(2, 1),
    BIG_STAFF(2, 2),
    STICK(3, 3),
    BIG_STICK(3, 6);

    private final int classNumber;
    private final int damage;

    Weapon(int classNumber, int damage) {
        this.classNumber = classNumber;
        this.damage = damage;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getClassNumber() {
        return classNumber;
    }
}
