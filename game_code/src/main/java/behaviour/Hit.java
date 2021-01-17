package behaviour;

import Entity.Entity;
import Entity.Enums.CharacterClass;
import Entity.Enums.Weapon;
import Entity.PlayerController;
import Entity.Melee;

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

    public void startHitting(int attackPoints, Entity target) {
        setAction();
        target.takeDamage(attackPoints);
    }

}
