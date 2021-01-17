package Entity;

import behaviour.IAction;

public class PlayerController {

    IAction currentAction;
    public IAction getCurrentAction() {
        return currentAction;
    }

    public void setCurrentAction(IAction currentAction) {
        this.currentAction = currentAction;
    }

    public void stopCurrentAction() {
        if (this.currentAction == null) {
            return;
        }
        this.currentAction.stopAction();
        this.currentAction = null;
    }
}
