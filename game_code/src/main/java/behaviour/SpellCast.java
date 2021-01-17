package behaviour;

import Player.Enums.SpellType;
import Player.Player;
import Player.PlayerController;

import java.util.ArrayList;

public class SpellCast implements IAction {

    PlayerController controller;
    Player player;
    private ArrayList<SpellType> spells;

    public SpellCast(PlayerController controller, Player player, ArrayList<SpellType> spells) {
        this.controller = controller;
        this.player = player;
        setInitialSpells(spells);
    }

    public void setAction() {
        controller.setCurrentAction(this);
    }

    public void stopAction() {

    }

    public void startCastingSpell(SpellType spell, Player target) {
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

    private void startCastingAttack(SpellType spell, Player target) {
        target.takeDamage(calculateDamage(spell));
    }

    private void startCastingHeal(SpellType spell, Player target) {
        target.heal(spell.getDamage());
    }

    private int calculateDamage(SpellType spell) {
        return spell.getDamage() + player.getRightHandWeapon().getDamage();
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
