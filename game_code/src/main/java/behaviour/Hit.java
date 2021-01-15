package behaviour;

import Player.Enums.Weapon;
import Player.Player;
import Player.PlayerController;

public class Hit implements IAction {
    PlayerController controller;

    public Hit(PlayerController controller) {
        this.controller = controller;
    }

    public void setAction() {
        controller.setCurrentAction(this);
    }

    public void stopAction() {

    }

    public void startHitting(int attackPoints, Player target) {
        setAction();
        target.takeDamage(attackPoints);
    }

}
