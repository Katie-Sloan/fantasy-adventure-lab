package Player;

import Player.Enums.CharacterClass;
import Player.Enums.Spell;
import Player.Enums.Weapon;
import behaviour.ISpell;

import java.util.ArrayList;

public class Magic extends Player implements ISpell {
    private ArrayList<Spell> spells;
//    private MythicalCreature pet;

    public Magic(String name, Weapon rightHandWeapon, int healthPoints, CharacterClass characterClass, ArrayList<Spell> spells) {
        super(name, rightHandWeapon, healthPoints, characterClass);
        setInitialSpells(spells);
    }

    public int spellCount() {
        return this.spells.size();
    }

    public void addSpell(Spell spell) {
        this.spells.add(spell);
    }

    public Spell getSpell(int index) {
        return spells.get(index);
    }

    public Spell hasSpell(Spell spellToFind) {
        for (Spell spell : this.spells) {
            if (spell == spellToFind) {
                return spell;
            }
        }
        return null;
    }


    public void castSpell(Spell spell) { }

//    public void castSpell(Spell spell, MythicalCreature opponent) {
//        opponent.takeDamage(spell.getDamage(), opponent);
//    }

    private void setInitialSpells(ArrayList<Spell> spells) {
        if(spells == null) {
            this.spells = new ArrayList<Spell>();
        }
        else {
            this.spells = spells;
        }
    }
}
