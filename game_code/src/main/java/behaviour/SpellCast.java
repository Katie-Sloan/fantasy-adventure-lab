package behaviour;

import Entity.Enums.SpellType;
import Entity.Entity;
import Entity.PlayerController;

import java.util.ArrayList;

public class SpellCast implements IAction {

    PlayerController controller;
    Entity entity;
    private ArrayList<SpellType> spells;

    public SpellCast(PlayerController controller, Entity entity, ArrayList<SpellType> spells) {
        this.controller = controller;
        this.entity = entity;
        setInitialSpells(spells);
    }

    public void setAction() {
        controller.setCurrentAction(this);
    }

    public void stopAction() {

    }

    public void startCastingSpell(SpellType spell, Entity target) {
        setAction();

        switch (spell.getType()) { // type of SpellCategory
            case HEALING:
                startCastingHeal(spell, target);
                break;
            case ATTACKING:
                startCastingAttack(spell, target);
                break;
        }
    }

    private void startCastingAttack(SpellType spell, Entity target) {
        target.takeDamage(calculateDamage(spell));
    }

    private void startCastingHeal(SpellType spell, Entity target) {
        target.heal(spell.getPower() + entity.getRightHandWeapon().getPower());
    }

    private int calculateDamage(SpellType spell) {
        return spell.getPower() + entity.getRightHandWeapon().getPower();
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

    public void setInitialSpells(ArrayList<SpellType> spells) {
        if(spells == null) {
            this.spells = new ArrayList<SpellType>();
        }
        else {
            this.spells = spells;
        }
    }

//    public void castSpell(Spell spell, Player opponent) {
//        opponent.takeDamage(spell.getDamage(), opponent);
//    }
}
