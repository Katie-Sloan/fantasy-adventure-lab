package Player;

import Player.Enums.CharacterClass;
import Player.Enums.SpellType;
import Player.Enums.Weapon;
import behaviour.Spell;

import java.util.ArrayList;

public class Magic extends Player{
    private ArrayList<SpellType> spells;
//    private MythicalCreature pet;
public Spell spell;

    public Magic(String name, Weapon rightHandWeapon, int healthPoints, CharacterClass characterClass, ArrayList<SpellType> spells) {
        super(name, rightHandWeapon, healthPoints, characterClass);
        setInitialSpells(spells);
        spell = new Spell(controller, this);
    }

    public int spellCount() {
        return this.spells.size();
    }

    public void addSpell(SpellType spell) {
        this.spells.add(spell);
    }

    public SpellType getSpell(int index) {
        return spells.get(index);
    }

    public SpellType hasSpell(SpellType spellToFind) {
        for (SpellType spell : this.spells) {
            if (spell == spellToFind) {
                return spell;
            }
        }
        return null;
    }


    public void castSpell(SpellType spell) { }


    private void setInitialSpells(ArrayList<SpellType> spells) {
        if(spells == null) {
            this.spells = new ArrayList<SpellType>();
        }
        else {
            this.spells = spells;
        }
    }
}
