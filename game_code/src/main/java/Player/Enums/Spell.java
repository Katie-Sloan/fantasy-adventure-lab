package Player.Enums;

import Player.Player;

public enum Spell {

    EXPELLIARMUS(2),
    WINGARDIUM_LEVIOSA(3);

    private final int damage;

    Spell(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return this.damage;
    }

}
