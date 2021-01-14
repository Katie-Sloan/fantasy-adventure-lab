package Player.Enums;

import Player.Player;

public enum HealItem {

    POTION(2),
    HERB(1);

    private final int healPoints;

    HealItem(int healPoints) {
        this.healPoints = healPoints;
    }

    public int getHealPoints() {
        return this.healPoints;
    }

}
