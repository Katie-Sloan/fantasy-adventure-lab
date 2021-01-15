package Player;

import behaviour.IAction;

public class PlayerController {

    IAction currentAction;
    public IAction getCurrentAction() {
        return currentAction;
    }

    public void setCurrentAction(IAction currentAction) {
        this.currentAction = currentAction;
        System.out.println("the current action is " + currentAction);
    }

    public void stopCurrentAction(){
        System.out.println("We are now stopping " + currentAction);
        this.currentAction.stopAction();
    }

    public void printWhatCurrentActionIs() {
        System.out.println("current action is " + currentAction);
    }

}
