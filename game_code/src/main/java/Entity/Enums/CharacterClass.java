package Entity.Enums;

public enum CharacterClass {

    DWARF(1),
    BARBARIAN(1),
    KNIGHT(1),
    WARLOCK(2),
    WIZARD(2),
    CLERIC(3),
    MONSTER(4);

    private final int characterClass;

    CharacterClass(int characterClass) {
        this.characterClass = characterClass;
    }

    public int getCharacterClass() {
        return characterClass;
    }
}
