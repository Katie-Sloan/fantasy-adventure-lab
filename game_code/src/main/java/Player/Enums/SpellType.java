package Player.Enums;

public enum SpellType {

    EXPELLIARMUS(2),
    WINGARDIUM_LEVIOSA(3),
    HEALIARMUS(1);

    private final int damage;

    SpellType(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return this.damage;
    }

}
