package behaviour;
import Player.PlayerController;

public class Move implements IAction {

    PlayerController controller;

    public Move(PlayerController controller) {
        this.controller = controller;
    }

    public void setAction() {
        controller.setCurrentAction(this);
    }

    public void stopAction() {

    }
}
