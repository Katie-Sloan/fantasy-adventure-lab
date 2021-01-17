package Player.Enums;

public enum SpellType {

    EXPELLIARMUS(2, SpellCategory.ATTACKING),
    WINGARDIUM_LEVIOSA(3, SpellCategory.ATTACKING),
    HEALIARMUS(1, SpellCategory.HEALING);

    private final int damage;
    private final SpellCategory type;

    SpellType(int damage, SpellCategory type) {
        this.damage = damage;
        this.type = type;
    }

    public int getDamage() {
        return this.damage;
    }

    public SpellCategory getType() {
        return this.type;
    }

    public enum SpellCategory {
        ATTACKING,
        HEALING
    }
}
