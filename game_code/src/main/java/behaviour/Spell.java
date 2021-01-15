package behaviour;

import Player.Player;
import Player.PlayerController;

public class Spell implements IAction {

    PlayerController controller;

    public Spell(PlayerController controller) {
        this.controller = controller;
    }

    public void setAction() {
        controller.setCurrentAction(this);
    }

    public void stopAction() {

    }

    public void startCastingSpell(int attackPoints, Player target) {
        setAction();
        target.takeDamage(attackPoints);
    }

}
