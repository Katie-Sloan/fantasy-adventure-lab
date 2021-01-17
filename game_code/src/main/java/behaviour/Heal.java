package behaviour;

import Player.Enums.HealItem;
import Player.Player;
import Player.PlayerController;

public class Heal implements IAction {

    PlayerController controller;
    Player player;

    public Heal(PlayerController controller, Player player) {
        this.controller = controller;
        this.player = player;
    }

    public void setAction() {
        controller.setCurrentAction(this);
    }

    public void stopAction() {

    }

    public void startHealing(HealItem healItem) {
        setAction();
        player.heal(healItem.getHealPoints());
    }
}
