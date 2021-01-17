package behaviour;

import Player.Enums.SpellType;
import Player.Player;
import Player.PlayerController;

public class Spell implements IAction {

    PlayerController controller;
    Player player;

    public Spell(PlayerController controller, Player player) {
        this.controller = controller;
        this.player = player;
    }

    public void setAction() {
        controller.setCurrentAction(this);
    }

    public void stopAction() {

    }

    public void startCastingSpell(SpellType spell, Player target) {
        setAction();
        target.takeDamage(calculateDamage(spell));
    }

    private int calculateDamage(SpellType spell) {
        return spell.getDamage() + player.getRightHandWeapon().getDamage();
    }

//    public void castSpell(Spell spell, Player opponent) {
//        opponent.takeDamage(spell.getDamage(), opponent);
//    }
}
