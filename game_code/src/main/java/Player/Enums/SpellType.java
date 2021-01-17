package Player.Enums;

public enum SpellType {

    EXPELLIARMUS(2, SpellCategory.ATTACKING),
    WINGARDIUM_LEVIOSA(3, SpellCategory.ATTACKING),
    HEALIARMUS(1, SpellCategory.HEALING);

    private final int power;
    private final SpellCategory type;

    SpellType(int power, SpellCategory type) {
        this.power = power;
        this.type = type;
    }

    public int getPower() {
        return this.power;
    }

    public SpellCategory getType() {
        return this.type;
    }

    public enum SpellCategory {
        ATTACKING,
        HEALING
    }
}
