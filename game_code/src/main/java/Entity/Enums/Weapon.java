package Entity.Enums;

public enum Weapon {

    AXE(1, 3),
    BIG_AXE(1, 6),
    CRAP_AXE(1, 2),
    STAFF(2, 1),
    BIG_STAFF(2, 2),
    DUMBLEDORES_WAND(2, 20),
    STICK(3, 3),
    BIG_STICK(3, 6),
    CLUB(4, 1),
    BIG_ASS_CLUB(4, 9);

    private final int classNumber;
    private final int power;

    Weapon(int classNumber, int power) {
        this.classNumber = classNumber;
        this.power = power;
    }

    public int getPower() {
        return this.power;
    }

    public int getClassNumber() {
        return classNumber;
    }
}
