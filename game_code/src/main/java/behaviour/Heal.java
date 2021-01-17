package behaviour;

import Entity.Enums.HealItem;
import Entity.Entity;
import Entity.PlayerController;

public class Heal implements IAction {

    PlayerController controller;
    Entity entity;

    public Heal(PlayerController controller, Entity entity) {
        this.controller = controller;
        this.entity = entity;
    }

    public void setAction() {
        controller.setCurrentAction(this);
    }

    public void stopAction() {

    }

    public void startHealing(HealItem healItem) {
        setAction();
        entity.heal(healItem.getHealPoints());
    }
}
